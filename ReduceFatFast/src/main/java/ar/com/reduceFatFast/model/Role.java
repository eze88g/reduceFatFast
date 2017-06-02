/**
 * 
 */
package ar.com.reduceFatFast.model;

/**
 * @author joaco
 *
 */
public enum Role {
    PERSON(0),
    MEDIC(1);
	
	private long id;
	
	Role(long id) {
        this.id = id;
    }
	
	public long id() {
        return id;
    }
}
