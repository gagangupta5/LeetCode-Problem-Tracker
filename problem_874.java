class Solution {
    public int robotSim(int[] cmd, int[][] obs) {
        int curx = 0, cury = 0;
        int ans = 0;
        boolean zero = false;

        //dir[i] = (hr,vr)
        int[][] dir = new int[][] {
                { 0, 1 },
                { 1, 0 },
                { 0, -1 },
                { -1, 0 }
        };
        //-2 -> left 
        //-1 -> right

        int idir = 0;

        //if using tree list the inputs will be in sorted order, easier to search
        Map<Integer, TreeSet<Integer>> obsx = new HashMap<>(); //same column
        Map<Integer, TreeSet<Integer>> obsy = new HashMap<>(); //same row

        for (int[] o : obs) {
            //same column obstacle at different height/row
            obsx.computeIfAbsent(o[0], k -> new TreeSet<>()).add(o[1]);

            //same row obstacle at different columns
            obsy.computeIfAbsent(o[1], k -> new TreeSet<>()).add(o[0]);

            if (o[0] == 0 && o[1] == 0) {
                zero = true;
            }
        }

        for (int c : cmd) {
            if (c == -2) { //turn left
                idir = (idir - 1 + 4) % 4;
            } 
            else if (c == -1) { //turn right
                idir = (idir + 1) % 4;
            } 
            else { //if i need to move

                //if starting at zero and obstacle at zero 
                if (zero) {
                    cury += c * dir[idir][1];
                    curx += c * dir[idir][0];
                    zero = false;
                }
                else{

                    int dirx = dir[idir][0];
                    int diry = dir[idir][1];

                    //moving horizontally
                    if (diry == 0) {
                        
                        //contains obstacle in this row
                        if (obsy.containsKey(cury)) { 

                            TreeSet<Integer> temp = obsy.get(cury);

                            if (dirx > 0) { //moving right
                                Integer r = temp.higher(curx);

                                //no obstacle or obstacle far away
                                if(r == null || curx + c < r){ 
                                    curx += c;
                                }
                                else{
                                //just one block before next obstacle 
                                    curx = r - 1; 
                                }
                            }
                            else { //moving left
                                Integer r = temp.lower(curx);
                                //if no obstacle or obstacle far away
                                if(r == null || curx - c > r){ 
                                    curx -= c;
                                }
                                else{
                                    curx = r + 1;
                                }
                            } 
                        } 
                        
                        //if no obstacle, freely move c 
                        else {
                            curx += c * dirx;
                        }
                    }
                    //moving vertically
                    else {

                    if (obsx.containsKey(curx)) { 
                            TreeSet<Integer> temp = obsx.get(curx);

                            //moving up
                            if (diry > 0) { 
                            Integer r = temp.higher(cury); 

                            //no obstacle or obstacle far away
                            if(r == null || cury + c < r){ 
                                cury += c;
                            }
                            //just one block before next obstacle 
                            else{
                                cury = r - 1; 
                            }
                            }
                            else { //moving down
                                Integer r = temp.lower(cury);
                                //if no obstacle or obstacle far away
                                if(r == null || cury - c > r){ 
                                    cury -= c;
                                }
                                else{
                                    cury = r + 1; //just one before
                                }
                            } 
                        } 
                        
                        else { 
                            cury += c * diry;
                        }
                    }
                }

                int d = curx * curx + cury * cury;
                ans = Math.max(ans, d);
            }
        }

        return ans;

    }
}