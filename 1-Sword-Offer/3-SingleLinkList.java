package list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author WuPing
 * @version 2016年4月11日 上午10:41:43
 */

public class SingleLinkList {

    class Element {
	public Value value = null;
	public Element nextNode = null;
    }

    class Value {
	public long code;
	public String name;

	public Value() {
	}

	public Value(long code, String name) {
	    this.code = code;
	    this.name = name;
	}

	@Override
	public String toString() {
	    return code + "-" + name;
	}
    }

    private Element header = null;

    public void add(Value node) {
	if (header == null) {
	    header = new Element();
	    header.value = null;
	    header.nextNode = null;
	}
	Element element = new Element();
	element.value = node;
	element.nextNode = header.nextNode;
	header.nextNode = element;
    }

    public void clear() {
	header = null;
    }

    public boolean contains(Object o) {
	if (header == null)
	    return false;
	Element eqEl = header.nextNode;
	while (eqEl != null) {
	    if (eqEl.value == o) {
		return true;
	    }
	    eqEl = eqEl.nextNode;
	}
	return false;
    }

    public String toString() {
	int size = this.size();
	String print = "";
	if (size == 0)
	    return print;
	for (int i = 0; i < size; i++) {
	    print = "," + this.get(i) + print;
	}
	print = "[" + print.substring(1) + "]";
	return print;
    }

    public Object get(int index) {
	if (header == null)
	    return null;
	int size = this.size();
	if (index > (size - 1) || index < 0) {
	    return null;
	}
	Element temp = header.nextNode;
	int i = 0;
	while (temp != null) {
	    if (index == i) {
		return temp.value;
	    }
	    i++;
	    temp = temp.nextNode;
	}
	return null;
    }

    public String getValueName(int index) {
	if (header == null)
	    return "";
	int size = this.size();
	if (index > (size - 1) || index < 0) {
	    return "";
	}
	Element temp = header.nextNode;
	int i = 0;
	while (temp != null) {
	    if (index == i) {
		return temp.value.name;
	    }
	    i++;
	    temp = temp.nextNode;
	}
	return "";
    }
    
    private Element getElement(int index) {
	if (header == null)
	    return null;
	int size = this.size();
	if (index > (size - 1) || index < 0) {
	    return null;
	}
	Element temp = header.nextNode;
	int i = 0;
	while (temp != null) {
	    if (index == i) {
		return temp;
	    }
	    i++;
	    temp = temp.nextNode;
	}
	return null;
    }

    public boolean isEmpty() {
	if (header == null)
	    return true;
	else
	    return false;
    }

    public boolean remove(Object o) {
	if (header == null)
	    return false;
	Element eqPreEl = header;
	Element eqEl = header.nextNode;
	while (eqEl != null) {
	    if (eqEl.value == o) {
		eqPreEl.nextNode = eqEl.nextNode;
		return true;
	    }
	    eqPreEl = eqEl;
	    eqEl = eqEl.nextNode;
	}
	return false;
    }

    public int size() {
	if (header == null)
	    return 0;
	Element temp = header.nextNode;
	int i = 0;
	while (temp != null) {
	    i++;
	    temp = temp.nextNode;
	}
	return i;
    }

    // 检查环状单链表
    public boolean checkLoop() {
	if (header == null)
	    return false;
	int size = this.size();
	if (size == 0)
	    return false;
	Set<Element> set = new HashSet<Element>();
	for (int i = 0; i < size; i++) {
	    Element el = getElement(i);
	    if (!set.contains(el)) {
		set.add(el);
	    }
	    if (set.contains(el.nextNode)) {
		return true;
	    }
	}
	return false;
    }

}
