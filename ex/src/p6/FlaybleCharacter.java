package p6;

public class FlaybleCharacter extends Character{
    private Character character;
    public FlaybleCharacter(Character character){
        this.character = character;
    }

    public void fly(){
        System.out.println("Flying");
    }

    @Override
    public int getExp() {
        return character.getExp();
    }

    @Override
    public void setExp(int exp) {
        character.setExp(exp);
    }

    @Override
    public boolean canFly() {
        return true;
    }

    @Override
    public boolean canSpeak() {
        return false;
    }

    @Override
    public void addExp(int n) {
        character.addExp(n);
    }
}
