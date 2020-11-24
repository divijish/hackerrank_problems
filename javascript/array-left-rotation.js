function rotateLeftDynamic(d, arr) {//For array, this is O(n^2), if TC of shift() is also considered.
    // Write your code here
    for(let i = 0; i< d; i++){
        let temp = arr.shift(); //Considering TC of shift() as O(n), this is expensive for array, but good for dynamic DS.
        arr.push(temp);
    }
    return arr;
}


function rotateLeftArray(d, arr) {
    // Write your code here
    
    let newArray = new Array(arr.length);
    for(let i = 0; i< arr.length; i++){
        
        i+d<arr.length?newArray[i] = arr[i+d]:newArray[i]=arr[i+d-arr.length];//For array, this is O(n)
    }
    return newArray;
}

console.log(rotateLeftDynamic(4, [1,2,3, 4, 5]));
console.log(rotateLeftArray(4, [1,2,3, 4, 5]));

//[5, 1, 2, 3, 4]