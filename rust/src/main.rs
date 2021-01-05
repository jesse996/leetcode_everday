use crate::t654::Solution;

mod offer;
mod t387;
mod t350;
mod t125;
mod t654;
mod t105;
mod t106;
mod t652;
mod t98;

fn main() {
    let vec = vec![3,2,1,6,0,5];
    dbg!(  Solution::construct_maximum_binary_tree(vec));
}