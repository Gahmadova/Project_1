package entity;

import java.util.Objects;

public class User {

        private int id;
        private String username;
        private String password;
        boolean isManager; // Boolean to check if you're manager

        public User(){

        }

        public User(String username, String password) {
            this.username = username;
            this.password = password;
            isManager = false;
        }


        @Override
        public String toString() {
            return "Users{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", isManager=" + isManager +
                    '}';
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return id == user.id && isManager == user.isManager && Objects.equals(username, user.username) && Objects.equals(password, user.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, username, password, isManager);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isManager() {
            return isManager;
        }

        public void setManager(boolean manager) {
            isManager = manager;
        }
}