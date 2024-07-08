import java.util.*;

public class Item_35 {
    // [page 223]
    static enum Permission {
        READ, WRITE, EXECUTE, DELETE
    }

    static class PermissionManager {

        private EnumSet<Permission> permissions;

        public PermissionManager() {
            this.permissions = EnumSet.noneOf(Permission.class);
        }

        // 권한 추가
        public void addPermission(Permission permission) {
            permissions.add(permission);
        }

        // 권한 제거
        public void removePermission(Permission permission) {
            permissions.remove(permission);
        }

        // 특정 권한 확인
        public boolean hasPermission(Permission permission) {
            return permissions.contains(permission);
        }

        // 모든 권한 확인
        public EnumSet<Permission> getPermissions() {
            return EnumSet.copyOf(permissions);
        }

        // 모든 권한 출력
        public void printPermissions() {
            for (Permission permission : permissions) {
                System.out.println(permission);
            }
        }
    }

    public static void main(String[] args){
        PermissionManager pm = new PermissionManager();

        // 권한 추가
        pm.addPermission(Permission.READ);
        pm.addPermission(Permission.WRITE);
        pm.printPermissions(); // 출력: 현재 권한: [READ, WRITE]

        // 권한 확인
        System.out.println("읽기 권한 있음: " + pm.hasPermission(Permission.READ)); // true
        System.out.println("실행 권한 있음: " + pm.hasPermission(Permission.EXECUTE)); // false

        // 권한 제거
        pm.removePermission(Permission.WRITE);
        pm.printPermissions(); // 출력: 현재 권한: [READ]
    }
}