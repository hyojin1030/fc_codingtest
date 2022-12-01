package data_structure;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    private ArrayList<Integer> heapArray = null;

    public Heap (Integer data) {
        heapArray = new ArrayList<>();

        heapArray.add(null);
        heapArray.add(data);
    }

    public boolean insert(Integer data) {
        Integer insertedIndex, parentIndex;

        if(heapArray == null) {
            heapArray = new ArrayList<>();
            heapArray.add(null);
            heapArray.add(data);
            return true;
        }

        this.heapArray.add(data);
        insertedIndex = this.heapArray.size() - 1;

        while (this.moveUp(insertedIndex)) {
            parentIndex = insertedIndex / 2;
            Collections.swap(this.heapArray, insertedIndex, parentIndex);
            insertedIndex = parentIndex;
        }
        return true;
    }

    public boolean moveUp(Integer insertedIndex) {
        if (insertedIndex <= 1) {
            return false;
        }
        Integer parentIndex = insertedIndex / 2;
        if (this.heapArray.get(insertedIndex) > this.heapArray.get(parentIndex)) {
            return true;
        } else { return false;}
    }

    public Integer pop() {
        Integer returnedData, poppedIndex, leftChild, rightChild;
        if (this.heapArray == null) {
            return null;
        } else {
            returnedData = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.size() - 1);
            this.heapArray.remove(this.heapArray.size() - 1);
            poppedIndex = 1;

            while (this.moveDown(poppedIndex)) {
                leftChild = poppedIndex * 2;
                rightChild = poppedIndex * 2 + 1;

                // Case2 : 오른쪽 자식 노드만 없을 때
                if (rightChild >= this.heapArray.size()) {
                    if (this.heapArray.get(poppedIndex) < this.heapArray.get(leftChild)){
                        Collections.swap(heapArray, poppedIndex, leftChild);
                        poppedIndex = leftChild;
                    }
                }
                // Case3 : 왼쪽, 오른쪽 자식 노두가 모두 있을 때
                else {
                    if (this.heapArray.get(leftChild) > this.heapArray.get(rightChild)) {
                        if (this.heapArray.get(poppedIndex) < this.heapArray.get(leftChild)) {
                            Collections.swap(this.heapArray, poppedIndex, leftChild);
                            poppedIndex = leftChild;
                        }
                    } else {
                        if (this.heapArray.get(poppedIndex) < this.heapArray.get(rightChild)) {
                            Collections.swap(this.heapArray, poppedIndex, rightChild);
                            poppedIndex = rightChild;
                        }
                    }
                }
            }

            return returnedData;
        }
    }

    public boolean moveDown(Integer poppedIndex) {
        Integer leftChild, rightChild;

        leftChild = poppedIndex * 2;
        rightChild = poppedIndex * 2 + 1;

        // Case1 : 왼쪽 자식 노드도 없을 때 == 자식 노드가 하나도 없을 때
        if (leftChild >= this.heapArray.size()) {
            return false;
        } else if (rightChild >= this.heapArray.size()){
            // Case2 : 오른쪽 자식 노드만 없을 때
            if (this.heapArray.get(poppedIndex) < this.heapArray.get(leftChild)) {
                return true;
            } else {
                return false;
            }
        } else {
            // Case3 : 왼쪽, 오른쪽 자식 노드가 모두 있을 때
            if (this.heapArray.get(leftChild) > this.heapArray.get(rightChild)){
                if (this.heapArray.get(poppedIndex) < this.heapArray.get(leftChild)){
                    return true;
                } else {
                    return false;
                }
            } else {
                if (this.heapArray.get(poppedIndex) < this.heapArray.get(rightChild)){
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(15);
        heap.insert(10);
        heap.insert(8);
        heap.insert(5);
        heap.insert(4);
        heap.insert(20);
        System.out.println(heap.heapArray);

        heap.pop();
        System.out.println(heap.heapArray);
    }
}
