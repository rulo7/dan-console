package es.raul.app.data.cache;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.util.List;

import es.raul.app.data.BuildConfig;
import es.raul.app.data.cache.serializer.JsonSerializer;
import es.raul.app.data.exception.NotFoundException;
import es.raul.app.data.local.FileManager;
import es.raul.app.domain.executor.ThreadExecutor;
import rx.Observable;

/**
 * Created by djuarez on 23/3/16.
 */
public abstract class DataCache<T> {

    private static final String SETTINGS_FILE_NAME = BuildConfig.APPLICATION_ID + ".SETTINGS";
    private static final String SETTINGS_KEY_LAST_CACHE_UPDATE = "last_cache_update";

    private static final long EXPIRATION_TIME = 60L * 10L * 1000L;
    protected final JsonSerializer<T> serializer;
    protected final FileManager fileManager;
    private final SharedPreferences sharedPreferences;
    private final File cacheDir;
    private final ThreadExecutor threadExecutor;

    public DataCache(Context context, JsonSerializer<T> userCacheSerializer, FileManager fileManager,
            ThreadExecutor executor) {
        if (context == null || userCacheSerializer == null || fileManager == null || executor == null) {
            throw new IllegalArgumentException("Invalid null parameter");
        }
        this.sharedPreferences = context.getSharedPreferences(SETTINGS_FILE_NAME, Context.MODE_PRIVATE);
        this.cacheDir = context.getCacheDir();
        this.serializer = userCacheSerializer;
        this.fileManager = fileManager;
        this.threadExecutor = executor;
    }

    public Observable<T> get() {
        return Observable.create(subscriber -> {
            File userEntityFile = DataCache.this.buildFile();
            String fileContent = DataCache.this.fileManager.readFileContent(userEntityFile);
            T entity = DataCache.this.serializer.deserialize(fileContent);
            if (entity != null) {
                subscriber.onNext(entity);
                subscriber.onCompleted();
            } else {
                subscriber.onError(new NotFoundException());
            }
        });
    }

    public void put(T entity) {
        if (entity != null) {
            File entitiyFile = buildFile();
            if (!isCached()) {
                String jsonString = this.serializer.serialize(entity);
                this.executeAsynchronously(new CacheWriter(this.fileManager, entitiyFile, jsonString));
                setLastCacheUpdateTimeMillis();
            }
        }
    }

    //<editor-fold desc="out & get list">
    public Observable<List<T>> getList() {
        return getList(-1, -1);
    }

    public void put(List<T> entityList) {
        put(entityList, -1, -1);
    }

    public Observable<List<T>> getList(int firstItem, int maxResults) {
        return Observable.create(subscriber -> {
            File entitiyFile = (firstItem > -1 && maxResults > -1) ? buildFile(firstItem, maxResults) : buildFile();
            String fileContent = DataCache.this.fileManager.readFileContent(entitiyFile);
            List<T> entity = DataCache.this.serializer.deserializeList(fileContent);
            if (entity != null) {
                subscriber.onNext(entity);
                subscriber.onCompleted();
            } else {
                subscriber.onError(new NotFoundException());
            }
        });
    }

    public void put(List<T> entityList, int firstItem, int maxResults) {
        if (entityList != null) {
            File entitiyFile = (firstItem > -1 && maxResults > -1) ? buildFile(firstItem, maxResults) : buildFile();
            String jsonString = this.serializer.serializeList(entityList);
            this.executeAsynchronously(new CacheWriter(this.fileManager, entitiyFile, jsonString));
            setLastCacheUpdateTimeMillis();
        }
    }
    //</editor-fold>

    public boolean isCached() {
        File userEntitiyFile = buildFile();
        return this.fileManager.exists(userEntitiyFile);
    }

    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        long lastUpdateTime = this.getLastCacheUpdateTimeMillis();
        boolean expired = currentTime - lastUpdateTime > EXPIRATION_TIME;
        if (expired) {
            this.evictAll();
        }
        return expired;
    }

    public void evictAll() {
        this.executeAsynchronously(new CacheEvictor(this.fileManager, this.cacheDir));
    }

    protected File buildFile() {
        String fileNameBuilder = this.cacheDir.getPath() +
                File.separator +
                getFilePrefixName() + "_";
        return new File(fileNameBuilder);
    }

    protected File buildFile(int firstItem, int maxItems) {
        String fileNameBuilder = this.cacheDir.getPath() +
                File.separator +
                getFilePrefixName() + "_" + firstItem + "x" + maxItems;
        return new File(fileNameBuilder);
    }

    private void setLastCacheUpdateTimeMillis() {
        long currentMillis = System.currentTimeMillis();
        this.fileManager.writeToPreferences(sharedPreferences, SETTINGS_KEY_LAST_CACHE_UPDATE, currentMillis);
    }

    private long getLastCacheUpdateTimeMillis() {
        return this.fileManager.getFromPreferences(sharedPreferences, SETTINGS_KEY_LAST_CACHE_UPDATE);
    }

    protected void executeAsynchronously(Runnable runnable) {
        this.threadExecutor.execute(runnable);
    }

    public abstract String getFilePrefixName();

    private static class CacheWriter implements Runnable {
        private final FileManager fileManager;
        private final File fileToWrite;
        private final String fileContent;

        CacheWriter(FileManager fileManager, File fileToWrite, String fileContent) {
            this.fileManager = fileManager;
            this.fileToWrite = fileToWrite;
            this.fileContent = fileContent;
        }

        @Override
        public void run() {
            this.fileManager.writeToFile(fileToWrite, fileContent);
        }
    }

    protected static class CacheEvictor implements Runnable {
        private final FileManager fileManager;
        private final File cacheDir;

        CacheEvictor(FileManager fileManager, File cacheDir) {
            this.fileManager = fileManager;
            this.cacheDir = cacheDir;
        }

        @Override
        public void run() {
            this.fileManager.clearDirectory(this.cacheDir);
        }
    }
}
