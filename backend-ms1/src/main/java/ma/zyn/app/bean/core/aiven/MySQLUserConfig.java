package ma.zyn.app.bean.core.aiven;

public class MySQLUserConfig {
        private final PublicAccess public_access;

        public MySQLUserConfig(PublicAccess public_access) {
            this.public_access = public_access;
        }

        public PublicAccess getPublic_access() {
            return public_access;
        }
}
