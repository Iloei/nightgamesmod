package nightgames.stance;

import nightgames.characters.Character;
import nightgames.combat.Combat;
import nightgames.global.Global;

public class UpsideDownFemdom extends FemdomSexStance {
    public UpsideDownFemdom(Character top, Character bottom) {
        super(top, bottom, Stance.upsidedownfemdom);
    }

    @Override
    public int pinDifficulty(Combat c, Character self) {
        return 8;
    }

    @Override
    public String describe() {
        if (top.human()) {
            return "You are holding " + bottom.name()
                            + " upsidedown by her legs while fucking her cock with your slit.";
        } else {
            return String.format("%s is holding %s upsidedown by %s legs while fucking %s cock with %s slit.",
                            top.subject(), bottom.nameDirectObject(), bottom.possessivePronoun(),
                            bottom.possessivePronoun(), top.possessivePronoun());
        }
    }

    @Override
    public String image() {
        return "upsidedownfemdom.jpg";
    }

    @Override
    public boolean mobile(Character c) {
        return c == top;
    }

    @Override
    public boolean kiss(Character c) {
        return false;
    }

    @Override
    public boolean dom(Character c) {
        return c == top;
    }

    @Override
    public boolean sub(Character c) {
        return c == bottom;
    }

    @Override
    public boolean reachTop(Character c) {
        return false;
    }

    @Override
    public boolean facing() {
        return false;
    }

    @Override
    public boolean reachBottom(Character c) {
        return true;
    }

    @Override
    public boolean prone(Character c) {
        return c == bottom;
    }

    @Override
    public boolean feet(Character c) {
        return false;
    }

    @Override
    public boolean oral(Character c) {
        return false;
    }

    @Override
    public boolean behind(Character c) {
        return false;
    }

    @Override
    public Position insertRandom() {
        return new StandingOver(top, bottom);
    }

    @Override
    public Position reverse(Combat c) {
        if (bottom.human()) {
            c.write(bottom, Global.format(
                            "Summoning your remaining strength, you hold your arms up against the floor and use your hips to tip {other:name-do} off-balance with self dick still held inside of {other:possessive}. "
                                            + "{other:SUBJECT} lands on the floor with you on top of {other:direct-object} in a missionary position.",
                            bottom, top));
        } else {
            c.write(bottom, Global.format(
                            "{self:SUBJECT} suddenly pushes against the floor and knocks you to the ground with {self:possessive} hips. "
                                            + "You land on the floor with {self:direct-object} on top of you, fucking you in a missionary position.",
                            bottom, top));
        }
        return new UpsideDownMaledom(bottom, top);
    }

    @Override
    public double pheromoneMod(Character self) {
        return 2;
    }
    
    @Override
    public int dominance() {
        return 4;
    }
}
