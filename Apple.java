public class Apple {
    
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean isEaten;

    public Apple(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        isEaten = false;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getWidth(){
        return this.width;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getHeight(){
        return this.height;
    }
    public void setIsEaten(boolean isEaten){
        this.isEaten = isEaten;
    }
    public boolean getIsEaten(){
        return this.isEaten;
    }
}