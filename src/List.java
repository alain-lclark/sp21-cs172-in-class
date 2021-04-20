public interface List<E> extends Iterable<E> {

    /**
     * Adds item to the end of the list.
     * @param item  item to be added
     */
    public abstract void add(E item);

    /**
     * Returns the element at position index.
     *
     * This method assumes that index is at least 0 and less than the list's size.
     *
     * @param index  position in the list
     * @return the element at the given index
     */
    public abstract E get(int index);

    /**
     * Removes the element at position index.
     *
     * It is assumed that index is at least 0 and less than the list's size.
     *
     * @param index  position in the list
     */
    public abstract void removeAt(int index);

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
     */
    public abstract int length();

}
