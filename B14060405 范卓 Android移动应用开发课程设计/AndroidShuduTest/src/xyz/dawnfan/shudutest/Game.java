package xyz.dawnfan.shudutest;

public class Game {  
	  
    //数独初始化数据的基础    将数字显示在矩形框里   空矩形框用0表示
    private final String str = "810000000007490800000006300"  
            +"060570004570000068900068070"  
            +"001700000005049600000000035";
    /*
     * str = "360000000004230800000004200"  
            +"070460003820000014500013020"  
            +"001900000007048300000000045";
     * 
     * 
     * */
      
    private int sudoku[] = new int[9*9];
    //用于存储每个单元格已经不可用的数据  
    private int used[][][] = new int[9][9][];  
    
    public Game() {
        sudoku = fromPuzzleString(str);
        calculateAllUsedTiles();
    }
      
    /** 
     * 根据一个字符串数据,生成一个整型数组,所谓数独游戏的初始化数据 
     * @param src 
     * @return 
     */  
    protected int[] fromPuzzleString(String src){  
        int[] sudo = new int[src.length()];  
          
        for(int i = 0 ; i < sudo.length ; ++i){  
            sudo[i] = src.charAt(i) - '0';   
        }  
          
        return sudo;  
    }
    
    /** 
     * 根据九宫格当中的坐标,返回该坐标所应该填写的数字 
     * @param x 
     * @param y 
     * @return 
     */  
    private int getTile(int x, int y){  
        return sudoku[y*9 + x];  
    }  
      
    /** 
     * 根据x轴坐标和y轴坐标得到这一单元格不可用的数据 
     * @param x 
     * @param y 
     * @return 
     */  
    public String getTileString(int x, int y){  
        int v = getTile(x,y);  
        if(v == 0){  
            return "";  
        }else{  
            return String.valueOf(v);  
        }  
    }  
      
      
      
    /** 
     * 计算所有单元格对应的不可用的数据 
     */  
    public void calculateAllUsedTiles(){  
        for(int x = 0 ; x < 9 ; ++x){  
            for(int y = 0 ; y < 9 ; ++y){  
                used[x][y] = calculateUsedTiles(x, y);  
            }  
        }  
    }  
      
      
    /** 
     * 取出某一单元格中已经不可用的数据 
     * @param x 
     * @param y 
     * @return 
     */  
    public int[] getUsedTilesByCoor(int x, int y){  
        return used[x][y];  
    }  
      
      
    /** 
     * 计算某一单元格之中已经不可用的数据 
     * @param x 
     * @param y 
     */  
    public int[] calculateUsedTiles(int x,int y) {  
        int c[] = new int[9];  
          
        //计算在y轴(列)方向上那些数字不可用
        for(int i = 0 ; i < 9 ; ++i){  
            if(i == y){//如果这是用户点击的格子  
                continue;  
            }  
              
            int t = getTile(x,i);  
            if(t != 0){  
                c[t - 1] = t;  
            }  
        }  
        //计算在x轴(行)方向上那些数字不可用 
        for(int i = 0 ; i < 9 ; ++i){  
            if(i == x){  
                continue;  
            }  
              
            int t = getTile(i,y);  
            if(t != 0){  
                c[t - 1] = t;  
            }  
        }  
          
        //计算在小的九宫格中有那些数字已经用过了 
        int startX = (x/3)*3;  
        int startY = (y/3)*3;  
        for(int i = startX ; i < startX + 3 ; ++i){  
            for(int j = startY ; j < startY + 3 ; ++j){  
                if(i == x && j == y){  
                    continue;  
                }  
                  
                int t = getTile(i, j);  
                if(t != 0 ){  
                    c[t - 1] = t;  
                }  
            }  
        }  
          
        //去掉数组c中的0,将非0的数组中的数字累计为nused
        int nused = 0;  
        for(int t : c){  
            if(t != 0){  
                nused++;  
            }  
        }  
        //定义新数组，大小为nused
        int c1[] = new int[nused];  
        nused = 0;  
        for(int t : c){  
            if(t != 0){  
                c1[nused++] = t;  
            }  
        }
        return c1;
    }  
  
  
  
    public boolean setTileIfValid(int x, int y, int value) {  
        int tiles[] = getUesdTiles(x,y);  
        if(value != 0){  
            for(int tile : tiles){  
                if(tile == value){  
                    return false;  
                }  
            }  
        }  
          
        setTile(x,y,value);//把用户输入的数字添加到九宫格中  
        calculateAllUsedTiles();//更新该单元格可以使用的数字  
        return true;  
    }  
  
  
  
    protected int[] getUesdTiles(int x, int y) {  
        return used[x][y];  
    }  
      
    private void setTile(int x, int y, int value){  
        sudoku[y*9 + x] = value;  
    }  
}