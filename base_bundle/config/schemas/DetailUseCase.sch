package _app_package_name_._packagename_;

import _app_package_name_.domain.executor.PostExecutionThread;
import _app_package_name_.domain.executor.ThreadExecutor;
import _app_package_name_.domain.model._Entityname_;
import _app_package_name_.domain.repository._Entityname_Repository;
import javax.inject.Inject;
import rx.Observable;

public class _Entityname_UseCase extends UseCase<_Entityname_> {

    private _Entityname_Repository _entityname_Repository;
    private int id;

    @Inject
    public _Entityname_UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
            _Entityname_Repository _entityname_Repository) {
        super(threadExecutor, postExecutionThread);
        this._entityname_Repository = _entityname_Repository;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    protected Observable<_Entityname_> buildUseCaseObservable() {
        return this._entityname_Repository._entityname_(id);
    }
}