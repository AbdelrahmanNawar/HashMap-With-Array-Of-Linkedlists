import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HashMap trail = new HashMap();
        trail.put("1", "7000");
        trail.put("19", "2");
        trail.put("3", "20000");
        System.out.println(trail.get("3"));
        trail.put("3", "90000");
        System.out.println(trail.get("3"));
        System.out.println(trail.get("2"));
        System.out.println(trail.get("1"));
        trail.remove("1");
        System.out.println(trail.get("1"));


    }
}

class HashMap {

    // create container that holds lists with method insert to put in list
    class Node {
        Object key;
        Object value;

        public void insert(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node n;
    private List<Node> headOfList;

    public HashMap() {
        this.headOfList = new ArrayList<Node>();
    }

    public void put(Object key, Object value) {
        this.n = new Node();
        n.insert(key, value);

        //loop if exists
        for (int i = 0; i < headOfList.size(); i++) {
            Node firstContainer = headOfList.get(i);
            if (firstContainer.key.equals(key)) {
                headOfList.remove(i);
                break;
            }
        }
        headOfList.add(n);
    }

    public Object get(Object key) {
        for (int i = 0; i < this.headOfList.size(); i++) {
            Node holder = headOfList.get(i);
            try {
                if (key.toString() == holder.key.toString()) {
                    return holder.value;
                }
            } catch (NullPointerException n){
                System.out.println("NOT FOUND!");
            }

        }
        return null;
    }

    public void remove (Object key){
        for (int i = 0; i < this.headOfList.size(); i++) {
            Node holder = headOfList.get(i);
            if (key.toString() == holder.key.toString()){
                holder.key = null;
                holder.value = null;
            }
        }
    }
}

