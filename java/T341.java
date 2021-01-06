import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: jesse
 * @Date: 2021/1/6 4:33 下午
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * <p>
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 * <p>
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T341 {
}

class NestedInteger {
    public boolean isInteger(){
        return true;
    }
    public Integer getInteger(){
        return 1;
    }
    public List<NestedInteger> getList(){
        return new ArrayList<>();
    };
}

class NestedIterator implements Iterator<Integer> {
    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> res = new LinkedList<>();
        for (NestedInteger nestedInteger : nestedList) {
            traverse(nestedInteger, res);
        }
        this.it = res.iterator();
    }
    private void traverse(NestedInteger nestedInteger,List<Integer> res){
        if (nestedInteger.isInteger()) {
            res.add(nestedInteger.getInteger());
        }else {
            for (NestedInteger integer : nestedInteger.getList()) {
                traverse(integer, res);
            }
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}