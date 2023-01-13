class Solution {
    private:
        double dist(vector<int>&p, vector<int>&q){
            return sqrt((q[0]-p[0])*(q[0]-p[0]) + (q[1]-p[1])*(q[1]-p[1]));
        }
    public:
        bool validSquare(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
            
            vector<vector<int>>coordinates = {p1, p2, p3, p4};
            
            set<double>length;
            
            for( int i =0; i <4; i++){
                for( int j =i+1; j <4; j++){
                    double distance = dist(coordinates[i], coordinates[j]);
                    
                    if(distance != 0){
                        length.insert(distance);
                    }
                    else{
                        return false;
                    }
                }
            }
            return length.size() == 2;
        }
    };