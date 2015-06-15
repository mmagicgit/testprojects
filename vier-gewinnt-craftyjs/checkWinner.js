function checkWinner(column, line) {
    return checkVertical(column) || checkHorizontal(line) || checkAscendingDiagonal(column, line) || checkDescendingDiagonal(column, line);
}

function checkVertical(column) {
    var counter = 0;
    for (var lineIndex = 0; lineIndex <= maxLine; lineIndex++) {
        counter = adjustCounter(counter, matrix[column][lineIndex]);
        if (counter == 4) {
            return true;
        }
    }
    return false;
}

function checkHorizontal(line) {
    var counter = 0;
    for (var columnIndex = 0; columnIndex <= maxColumn; columnIndex++) {
        counter = adjustCounter(counter, matrix[columnIndex][line]);
        if (counter == 4) {
            return true;
        }
    }
    return false;
}

function checkAscendingDiagonal(column, line) {
    var startColumn = column;
    var startLine = line;
    while (startColumn > 0 && startLine > 0) {
        startColumn = startColumn - 1;
        startLine = startLine - 1;
    }
    var counter = 0;
    for (; startColumn <= maxColumn && startLine <= maxLine; startColumn++, startLine++) {
        counter = adjustCounter(counter, matrix[startColumn][startLine]);
        if (counter == 4) {
            return true;
        }
    }
    return false;
}

function checkDescendingDiagonal(column, line) {
    var startColumn = column;
    var startLine = line;
    while (startColumn < maxColumn && startLine > 0) {
        startColumn = startColumn + 1;
        startLine = startLine - 1;
    }
    var counter = 0;
    for (; startColumn >= 0 && startLine <= maxLine; startColumn--, startLine++) {
        counter = adjustCounter(counter, matrix[startColumn][startLine]);
        if (counter == 4) {
            return true;
        }
    }
    return false;
}

function adjustCounter(counter, itemToCheck) {
    return itemToCheck == player ? counter + 1 : 0;
}
