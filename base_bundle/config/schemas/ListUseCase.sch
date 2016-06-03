package _app_package_name_._packagename_;

import _app_package_name_.domain.executor.PostExecutionThread;
import _app_package_name_.domain.executor.ThreadExecutor;
import _app_package_name_.domain.model._Entityname_;
import _app_package_name_.domain.repository._Entityname_Repository;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

public class _Entityname_ListUseCase extends UseCase<List<_Entityname_>> {

    private _Entityname_Repository _entityname_Repository;
    private Integer page;
    private Integer perPage;

    @Inject
    public _Entityname_ListUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
            _Entityname_Repository _entityname_Repository) {
        super(threadExecutor, postExecutionThread);
        this._entityname_Repository = _entityname_Repository;
    }

    public void setPagination(int page, int perPage) {
        this.page = page;
        this.perPage = perPage;
    }

    @Override
    protected Observable<List<_Entityname_>> buildUseCaseObservable() {
        return this._entityname_Repository._entityname_List(page, perPage);
    }
}