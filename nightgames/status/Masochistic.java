package nightgames.status;

import nightgames.characters.Attribute;
import nightgames.characters.Character;
import nightgames.characters.Emotion;
import nightgames.combat.Combat;

public class Masochistic extends DurationStatus {
	public Masochistic(Character affected) {
		super("Masochism", affected, 10);
		flag(Stsflag.masochism);
	}

	@Override
	public String describe() {
		if(affected.human()){
			return "Arousing fantasies of being hurt continue to tempt you.";
		}
		else{
			return affected.name()+" is still flushed with arousal at the idea of being struck.";
		}
	}
	@Override
	public String initialMessage(Combat c, boolean replaced) {
		return String.format("%s now affected by masochistic tendencies.\n", affected.subjectAction("are", "is"));
	}

	@Override
	public float fitnessModifier () {
		return -.5f;
	}

	@Override
	public int mod(Attribute a) {
		return 0;
	}

	@Override
	public int regen(Combat c) {
		super.regen(c);
		affected.emote(Emotion.nervous, 5);
		affected.emote(Emotion.horny, 5);
		return 0;
	}

	@Override
	public int damage(Combat c, int x) {
		return 0;
	}

	@Override
	public double pleasure(Combat c, double x) {
		return 0;
	}

	@Override
	public int weakened(int x) {
		return 0;
	}

	@Override
	public int tempted(int x) {
		return 0;
	}

	@Override
	public int evade() {
		return 0;
	}

	@Override
	public int escape() {
		return 0;
	}

	@Override
	public int gainmojo(int x) {
		return 0;
	}

	@Override
	public int spendmojo(int x) {
		return 0;
	}

	@Override
	public int counter() {
		return 0;
	}

	@Override
	public int value() {
		return 0;
	}
	@Override
	public Status instance(Character newAffected, Character newOther) {
		return new Masochistic(newAffected);
	}
}
