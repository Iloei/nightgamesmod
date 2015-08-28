package nightgames.status;

import nightgames.characters.Attribute;
import nightgames.characters.Character;
import nightgames.combat.Combat;

public class Satiated extends DurationStatus {
	int value;
	public Satiated(Character affected, int xp, int levels) {
		super("Satiated", affected, 1);
		this.value = xp + 95 + (5 * (affected.getLevel() + levels));
	}
	public Satiated(Character affected, int value) {
		super("Satiated", affected, 1);
		this.value = value;
	}

	@Override
	public String describe() {
		if (affected.human()) {
			return "You feel immensely powerful after feeding on your opponent's essence\n";
		} else {
			return affected.name() + " feels immensely satisfied after feeding on your essence\n";
		}
	}

	@Override
	public String initialMessage(Combat c, boolean replaced) {
		return String.format("%s now satiated.\n", affected.subjectAction("are", "is"));
	}

	@Override
	public float fitnessModifier () {
		return value / 10;
	}
	
	@Override
	public int mod(Attribute a) {
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
		return new Satiated(newAffected, value);
	}
}
