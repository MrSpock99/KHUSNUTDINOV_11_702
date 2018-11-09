package p6;

public class SpeakableCharacter extends Character{
    private Character character;
    public SpeakableCharacter(Character character){
        this.character = character;

    }

    public void speak(){
        System.out.println("Speaking");
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
        return true;
    }

    @Override
    public void addExp(int n) {
        character.addExp(n);
    }
}
