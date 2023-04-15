package sync;


import java.util.HashMap;
import java.util.Map;

public class StudentStorage implements Storage<Student>, Transferable {
    private  final Map<Integer,Student> students = new HashMap<>();
    @Override
    public boolean transfer(int fromId, int toId, int scope) {
        if (!students.containsKey(fromId) || !students.containsKey(toId)) {
            return false;
        }
        Student userFrom = students.get(fromId);
        Student userTo = students.get(toId);
        if (userFrom.getScore() - scope < 0) {
            return false;
        }
        userFrom.setScore(userFrom.getScore() - scope);
        userTo.setScore(userTo.getScore() + scope);
        return true;

    }

    @Override
    public synchronized boolean add(Student st) {
        if(st==null){
            return false;
        }else {
            students.put(st.getId(),st);
            return true;
        }

    }

    @Override
    public synchronized boolean update(Student st) {
        if(st==null) return  false;
        if(!students.containsKey(st.getId())){
            this.add(st);
        }else {
            students.put(st.getId(),st);
        }
        return false;
    }

    @Override
    public synchronized boolean delete(Student st) {
        if(st==null){
            return false;
        }else {
            students.remove(st.getId());
            return true;
        }

    }
}
