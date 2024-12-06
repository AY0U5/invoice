package ma.zyn.app.bean.core.aiven;

public class PublicAccess {
        private final boolean mysql;

        public PublicAccess(boolean mysql) {
            this.mysql = mysql;
        }

        public boolean isMysql() {
            return mysql;
        }
}
