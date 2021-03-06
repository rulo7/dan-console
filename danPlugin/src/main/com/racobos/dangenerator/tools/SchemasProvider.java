package com.racobos.dangenerator.tools;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import java.io.IOException;

/**
 * @author raulcobos
 */
public class SchemasProvider {

    public static final String SCHEMAS_PATH = DanFileProvider.CONFIG_PATH + "schemas/";

    private static final String ENTITY_SCH = "Entity.sch";

    public static String getEntitySchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, ENTITY_SCH));
    }

    private static final String MAPPER_SCH = "Mapper.sch";

    public static String getMapperSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, MAPPER_SCH));
    }

    private static final String CACHE_SCH = "Cache.sch";

    public static String getCacheSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, CACHE_SCH));
    }

    private static final String DATAREPOSITORY_SCH = "DataRepository.sch";

    public static String getDataRepositorySchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, DATAREPOSITORY_SCH));
    }

    private static final String DATASTORE_SCH = "DataStore.sch";

    public static String getDataStoreSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, DATASTORE_SCH));
    }

    private static final String CLOUDDATASTORE_SCH = "CloudDataStore.sch";

    public static String getCloudDataStoreSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, CLOUDDATASTORE_SCH));
    }

    private static final String DISKDATASTORE_SCH = "DiskDataStore.sch";

    public static String getDiskDataStoreSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, DISKDATASTORE_SCH));
    }

    private static final String DATAFACTORY_SCH = "DataFactory.sch";

    public static String getDataFactoryStoreSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, DATAFACTORY_SCH));
    }

    private static final String MODEL_SCH = "Model.sch";

    public static String getModelSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, MODEL_SCH));
    }

    private static final String REPOSITORY_SCH = "Repository.sch";

    public static String getRepositorySchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, REPOSITORY_SCH));
    }

    private static final String DETAIL_USECASE_SCH = "DetailUseCase.sch";

    public static String getDetailUseCaseSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, DETAIL_USECASE_SCH));
    }

    private static final String LIST_USECASE_SCH = "ListUseCase.sch";

    public static String getListUseCaseSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, LIST_USECASE_SCH));
    }

    private static final String APPLICATIONCOMPONENT_SCH = "ApplicationComponent.sch";

    public static String getApplicationComponentSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, APPLICATIONCOMPONENT_SCH));
    }

    private static final String APPLICATIONMODULE_SCH = "ApplicationModule.sch";

    public static String getApplicationModuleSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, APPLICATIONMODULE_SCH));
    }

    private static final String ACTIVITY_SCH = "Activity.sch";

    public static String getActivitySchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, ACTIVITY_SCH));
    }

    private static final String ACTIVITYCOMPONENT_SCH = "ActivityComponent.sch";

    public static String getActivityComponentSchema() throws IOException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, ACTIVITYCOMPONENT_SCH));
    }

    private static final String MANIFEST_SCH = "AndroidManifest.sch";

    public static String getManifestSchema() throws IOException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, MANIFEST_SCH));
    }

    private static final String FRAGMENTCOMPONENT_SCH = "FragmentComponent.sch";

    public static String getFragmentComponentSchema() throws IOException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, FRAGMENTCOMPONENT_SCH));
    }

    private static final String FRAGMENT_SCH = "Fragment.sch";

    public static String getFragmentSchema() throws IOException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, FRAGMENT_SCH));
    }

    private static final String VIEW_SCH = "View.sch";

    public static String getViewSchema() throws IOException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, VIEW_SCH));
    }

    private static final String PRESENTER_SCH = "Presenter.sch";

    public static String getPresenterSchema() throws IOException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, PRESENTER_SCH));
    }
}
