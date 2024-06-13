class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int countSeats[] = new int[101];
        int countStudents[] = new int[101];
        for(int i=0;i<seats.length;i++){
            countSeats[seats[i]]++;
            countStudents[students[i]]++;
        }
        int i=0,j=0;
        int res=0;
        while(i<101 && j<101){
            while(i<101 && countSeats[i]==0) i++;
            while(j<101 && countStudents[j]==0) j++;
            if(i>=101 && j>=101) break;
            res+=Math.abs(i-j);
            countSeats[i]--;
            countStudents[j]--;
            if(countSeats[i]==0) i++;
            if(countStudents[j]==0) j++;
        }
        return res;
    }
}