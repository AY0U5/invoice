package ma.zyn.app.bean.core.aiven;

    public class AivenServiceRequest {
        private final String cloud;
        private final String plan;
        private final String service_name;
        private final String service_type;
        private final MySQLUserConfig mysql_user_config;

        public AivenServiceRequest(String cloud, String plan, String service_name, String service_type, MySQLUserConfig mysql_user_config) {
            this.cloud = cloud;
            this.plan = plan;
            this.service_name = service_name;
            this.service_type = service_type;
            this.mysql_user_config = mysql_user_config;
        }

        // Getters for serialization
        public String getCloud() { return cloud; }
        public String getPlan() { return plan; }
        public String getService_name() { return service_name; }
        public String getService_type() { return service_type; }
        public MySQLUserConfig getMysql_user_config() { return mysql_user_config; }
    }
