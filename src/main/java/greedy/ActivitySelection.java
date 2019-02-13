package greedy;

import java.util.*;

public class ActivitySelection {
    public static void main(String args[]) {
        Map<Integer,Integer> map = new HashMap<>();

        System.out.print("map");


        /*
        List<Activity> activities = getActivities();
        Collections.sort(activities,new SortByEndTimeComparator());
        int maxActivity = getMaxActivities(activities);
        System.out.print(activities);*/
    }

    private static int getMaxActivities(List<Activity> activities) {
        int maxActivity = 1;
        int j = 0;
        for (int i = 1; i < activities.size(); i++) {
            if (activities.get(i).getStartTime() >= activities.get(j).getEndTime()) {
                maxActivity++;
                j = i;
            }
        }
        return maxActivity;
    }


    public static List<Activity> getActivities(){
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(12,25));
        activities.add(new Activity(10,20));
        activities.add(new Activity(20,30));
        return activities;
    }
}

class Activity {
    private int startTime;
    private int endTime;

    public Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}


class SortByEndTimeComparator implements Comparator<Activity>{

    @Override
    public int compare(Activity o1, Activity o2) {

        if (o1.getEndTime() == o2.getEndTime()) {
            return 0;
        } else if (o1.getEndTime() > o2.getEndTime()) {
            return 1;
        } else {
            return -1;
        }
    }
}