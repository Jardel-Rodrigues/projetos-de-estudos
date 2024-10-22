const n = document.getElementById("dados").innerHTML.split("\n").map(x => Number(x))

for(let i = 1; i <= 10; i++) {
    console.log(n * i);
}