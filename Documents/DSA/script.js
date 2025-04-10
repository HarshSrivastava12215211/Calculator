function appendValue(value) {
    document.getElementById('result').value += value;
}

function clearResult() {
    document.getElementById('result').value = '';
}

function calculate() {
    try {
        document.getElementById('result').value = eval(document.getElementById('result').value);
    } catch (error) {
        alert('Invalid calculation');
    }
}
