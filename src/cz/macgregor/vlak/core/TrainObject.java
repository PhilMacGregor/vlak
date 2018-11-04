package cz.macgregor.vlak.core;

public class TrainObject extends GameObject {

	private TrainObject next;

	private TrainObject previous;

	public TrainObject(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void move(int x, int y) {
		if (this.next != null && this.coords != null) {
			next.move(coords.x, coords.y);
		}
		this.parent.moveObject(x, y, layer, this);
	}

	public GameObject getNext() {
		return next;
	}

	public TrainObject getFirst() {
		if (previous == null) {
			return this;
		} else {
			return previous.getFirst();
		}
	}

	public TrainObject getLast() {
		if (next == null) {
			return this;
		} else {
			return next.getLast();
		}
	}

	public TrainObject setNext(TrainObject next) {
		this.next = next;
		next.parent = this.parent;
		next.previous = this;
		return next;
	}
}
