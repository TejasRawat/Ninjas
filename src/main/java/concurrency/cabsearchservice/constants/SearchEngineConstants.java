package concurrency.cabsearchservice.constants;

public class SearchEngineConstants {

    public enum CabSupplier {
        Ola(1), Uber(2), Grab(3);

        private int id;

        CabSupplier(int id) {
            this.id = id;
        }

        public int getCode() {
            return id;
        }

    }

}
