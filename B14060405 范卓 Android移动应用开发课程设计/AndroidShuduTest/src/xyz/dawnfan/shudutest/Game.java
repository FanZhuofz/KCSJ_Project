package xyz.dawnfan.shudutest;

public class Game {  
	  
    //������ʼ�����ݵĻ���    ��������ʾ�ھ��ο���   �վ��ο���0��ʾ
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
    //���ڴ洢ÿ����Ԫ���Ѿ������õ�����  
    private int used[][][] = new int[9][9][];  
    
    public Game() {
        sudoku = fromPuzzleString(str);
        calculateAllUsedTiles();
    }
      
    /** 
     * ����һ���ַ�������,����һ����������,��ν������Ϸ�ĳ�ʼ������ 
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
     * ���ݾŹ����е�����,���ظ�������Ӧ����д������ 
     * @param x 
     * @param y 
     * @return 
     */  
    private int getTile(int x, int y){  
        return sudoku[y*9 + x];  
    }  
      
    /** 
     * ����x�������y������õ���һ��Ԫ�񲻿��õ����� 
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
     * �������е�Ԫ���Ӧ�Ĳ����õ����� 
     */  
    public void calculateAllUsedTiles(){  
        for(int x = 0 ; x < 9 ; ++x){  
            for(int y = 0 ; y < 9 ; ++y){  
                used[x][y] = calculateUsedTiles(x, y);  
            }  
        }  
    }  
      
      
    /** 
     * ȡ��ĳһ��Ԫ�����Ѿ������õ����� 
     * @param x 
     * @param y 
     * @return 
     */  
    public int[] getUsedTilesByCoor(int x, int y){  
        return used[x][y];  
    }  
      
      
    /** 
     * ����ĳһ��Ԫ��֮���Ѿ������õ����� 
     * @param x 
     * @param y 
     */  
    public int[] calculateUsedTiles(int x,int y) {  
        int c[] = new int[9];  
          
        //������y��(��)��������Щ���ֲ�����
        for(int i = 0 ; i < 9 ; ++i){  
            if(i == y){//��������û�����ĸ���  
                continue;  
            }  
              
            int t = getTile(x,i);  
            if(t != 0){  
                c[t - 1] = t;  
            }  
        }  
        //������x��(��)��������Щ���ֲ����� 
        for(int i = 0 ; i < 9 ; ++i){  
            if(i == x){  
                continue;  
            }  
              
            int t = getTile(i,y);  
            if(t != 0){  
                c[t - 1] = t;  
            }  
        }  
          
        //������С�ľŹ���������Щ�����Ѿ��ù��� 
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
          
        //ȥ������c�е�0,����0�������е������ۼ�Ϊnused
        int nused = 0;  
        for(int t : c){  
            if(t != 0){  
                nused++;  
            }  
        }  
        //���������飬��СΪnused
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
          
        setTile(x,y,value);//���û������������ӵ��Ź�����  
        calculateAllUsedTiles();//���¸õ�Ԫ�����ʹ�õ�����  
        return true;  
    }  
  
  
  
    protected int[] getUesdTiles(int x, int y) {  
        return used[x][y];  
    }  
      
    private void setTile(int x, int y, int value){  
        sudoku[y*9 + x] = value;  
    }  
}