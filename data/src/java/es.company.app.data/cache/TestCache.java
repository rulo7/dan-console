package es.company.app.data.cache;

import android.content.Context;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import es.company.app.data.entity.Test;
import es.company.app.data.cache.serializer.JsonSerializer;
import es.company.app.data.cache.DataCache;
import es.company.app.data.cache.FileManager;
import es.company.app.data.exception.NotFoundException;
import es.company.app.domain.executor.ThreadExecutor;

@Singleton
public class TestCache extends DataCache<TestEntity> {

    @Inject
    public TestCache(Context context, FileManager fileManager, ThreadExecutor executor) {
        super(context, new JsonSerializer<>(TestEntity.class), fileManager, executor);
    }

    @Override
    public String getFilePrefixName() {
        return TestEntity.class.getSimpleName();
    }

    public Observable<TestEntity> get(int id) {
        return Observable.create(subscriber -> {
            File testEntityFile = TestCache.this.buildFile();
            String fileContent = TestCache.this.fileManager.readFileContent(testFile);
            List<TestEntity> entities = TestCache.this.serializer.deserializeList(fileContent);
            if (entities != null) {
                for (TestEntity testEntity : entities) {
                    if (testEntity.getId()) == id) {
                        subscriber.onNext(testEntity);
                        subscriber.onCompleted();
                        return;
                    }
                }
            }
            subscriber.onError(new NotFoundException());
        });
    }
}