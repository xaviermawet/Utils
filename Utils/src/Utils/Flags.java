package Utils;

import java.io.Serializable;

/**
 *
 * @author nakim
 */
public class Flags implements Serializable
{

    /**
     * Represents the current flag state.
     */
    private long flags = 0;

    /**
     * Create a new Flags object.
     */
    public Flags() {
        super();
    }

    /**
     * Initialize a new Flags object with the given flags.
     *
     * @param flags collection of boolean flags to represent.
     */
    public Flags(long flags) {
        super();
        this.flags = flags;
    }

    /**
     * Returns the current flags.
     *
     * @return collection of boolean flags represented.
     */
    public long getFlags() {
        return this.flags;
    }

    /**
     * Tests whether the given flag is on.  If the flag is not a power of 2 
     * (ie. 3) this tests whether the combination of flags is on.
     *
     * @param flag Flag value to check.
     *
     * @return whether the specified flag value is on.
     */
    public boolean isOn(long flag) {
        return (this.flags & flag) > 0;
    }

    /**
     * Tests whether the given flag is off.  If the flag is not a power of 2 
     * (ie. 3) this tests whether the combination of flags is off.
     *
     * @param flag Flag value to check.
     *
     * @return whether the specified flag value is off.
     */
    public boolean isOff(long flag) {
        return (this.flags & flag) == 0;
    }

    /**
     * Turns on the given flag.  If the flag is not a power of 2 (ie. 3) this
     * turns on multiple flags.
     *
     * @param flag Flag value to turn on.
     */
    public void turnOn(long flag) {
        this.flags |= flag;
    }

    /**
     * Turns off the given flag.  If the flag is not a power of 2 (ie. 3) this
     * turns off multiple flags.
     *
     * @param flag Flag value to turn off.
     */
    public void turnOff(long flag) {
        this.flags &= ~flag;
    }

    /**
     * Turn off all flags.
     */
    public void turnOffAll() {
        this.flags = 0;
    }
    
    /**
     * Turn off all flags.  This is a synonym for <code>turnOffAll()</code>.
     * @since Validator 1.1.1
     */
    public void clear() {
        this.flags = 0;
    }

    /**
     * Turn on all 64 flags.
     */
    public void turnOnAll() {
        this.flags = Long.MAX_VALUE;
    }

    /**
     * Clone this Flags object.
     *
     * @return a copy of this object.
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch(CloneNotSupportedException e) {
            throw new RuntimeException("Couldn't clone Flags object.");
        }
    }

    /**
     * Tests if two Flags objects are in the same state.
     * @param obj object being tested
     * @see java.lang.Object#equals(java.lang.Object)
     *
     * @return whether the objects are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Flags)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        Flags f = (Flags) obj;

        return this.flags == f.flags;
    }

    /**
     * The hash code is based on the current state of the flags.
     * @see java.lang.Object#hashCode()
     *
     * @return the hash code for this object.
     */
    @Override
    public int hashCode() {
        return (int) this.flags;
    }

    /**
     * Returns a 64 length String with the first flag on the right and the 
     * 64th flag on the left.  A 1 indicates the flag is on, a 0 means it's 
     * off.
     *
     * @return string representation of this object.
     */
    @Override
    public String toString() {
        StringBuffer bin = new StringBuffer(Long.toBinaryString(this.flags));
        for (int i = 64 - bin.length(); i > 0; i--) {
            bin.insert(0, "0");
        }
        return bin.toString();
    }

}
