package ma.zyn.app.bean.core.render;

public class ServiceRequest {
        private final String name;
        private final String serviceType;
        private final String repo;
        private final String branch;
        private final String rootDir;
        private final String env;
        private final String buildCommand;
        private final String startCommand;
        private final boolean manualDeploy;

        public ServiceRequest(String name, String serviceType, String repo, String branch, String rootDir, String env, String buildCommand, String startCommand, boolean manualDeploy) {
            this.name = name;
            this.serviceType = serviceType;
            this.repo = repo;
            this.branch = branch;
            this.rootDir = rootDir;
            this.env = env;
            this.buildCommand = buildCommand;
            this.startCommand = startCommand;
            this.manualDeploy = manualDeploy;
        }

        // Getters (required for Jackson serialization)
        public String getName() {
            return name;
        }

        public String getServiceType() {
            return serviceType;
        }

        public String getRepo() {
            return repo;
        }

        public String getBranch() {
            return branch;
        }

        public String getRootDir() {
            return rootDir;
        }

        public String getEnv() {
            return env;
        }

        public String getBuildCommand() {
            return buildCommand;
        }

        public String getStartCommand() {
            return startCommand;
        }

        public boolean isManualDeploy() {
            return manualDeploy;
        }
}
