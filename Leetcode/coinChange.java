class coinChange {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][]dp=new int[amount+1][n];
        for(int i=0;i<=amount;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
         return  fn(amount,0,coins,dp);
    
        
    }
    private int fn(int remS,int start,int []coins,int[][]dp){
        if(remS==0)return 1;
        if(remS<0)return 0;
        if(dp[remS][start]!=-1)return dp[remS][start];
        int ways=0;
        for(int i=start;i<coins.length;i++){
            ways=ways+fn(remS-coins[i],i,coins,dp);
        }
        dp[remS][start]=ways;
        return ways;
     
    }
      
}