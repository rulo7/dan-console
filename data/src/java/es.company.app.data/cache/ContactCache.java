package data.cache;

import android.content.Context;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import _entity_package_.Contact;
import es.company.app.data.cache.serializer.JsonSerializer;
import es.company.app.data.cache.DataCache;
import es.company.app.data.cache.FileManager;
import es.company.app.data.exception.NotFoundException;
import es.company.app.domain.executor.ThreadExecutor;

@Singleton
public class ContactCache extends DataCache<ContactEntity> {

    @Inject
    public ContactCache(Context context, FileManager fileManager, ThreadExecutor executor) {
        super(context, new JsonSerializer<>(NotaPrensaEntity.class), fileManager, executor);
    }

    @Override
    public String getFilePrefixName() {
        return ContactEntity.class.getSimpleName();
    }

    public Observable<_entitname_Entity> get(int id) {
        return Observable.create(subscriber -> {
            File contactEntityFile = ContactCache.this.buildFile();
            String fileContent = ContactCache.this.fileManager.readFileContent(contactFile);
            List<NotaPrensaEntity> entities = NotaPrensaCache.this.serializer.deserializeList(fileContent);
            if (entities != null) {
                for (ContactEntity contactEntity : entities) {
                    if (contactEntity.getId()) == id) {
                        subscriber.onNext(contactEntity);
                        subscriber.onCompleted();
                        return;
                    }
                }
            }
            subscriber.onError(new NotFoundException());
        });
    }
}