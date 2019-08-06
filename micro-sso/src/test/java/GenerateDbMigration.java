import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;
import java.io.IOException;

public class GenerateDbMigration {

  /**
   * Generate the next "DB schema DIFF" migration.
   */
  public static void main(String[] args) throws IOException {


    DbMigration dbMigration = DbMigration.create();
    dbMigration.setPlatform(Platform.MYSQL);
    dbMigration.setPathToResources("E:/work/firstdemo/micro-sso/src/main/resources");
    dbMigration.generateMigration();
  }
}