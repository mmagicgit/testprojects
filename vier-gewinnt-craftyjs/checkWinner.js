function checkWinner(column, line) {
    return checkVertical(column) || checkHorizontal(line) || checkAscendingDiagonal(column, line) || checkDescendingDiagonal(column, line);
}

function checkVertical(column) {
    var counter = 0;
    for (var lineIndex = 0; lineIndex <= maxLine; lineIndex++) {
        if (matrix[column][lineIndex] == player) {
            counter++;
        } else {
            counter = 0;
        }
        if (counter == 4) {
            return true;
        }
    }
    return false;
}

function checkHorizontal(line) {
    var counter = 0;
    for (var columnIndex = 0; columnIndex <= maxColumn; columnIndex++) {
        if (matrix[columnIndex][line] == player) {
            counter++;
        } else {
            counter = 0;
        }
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
        if (matrix[startColumn][startLine] == player) {
            counter++;
        } else {
            counter = 0;
        }
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
        if (matrix[startColumn][startLine] == player) {
            counter++;
        } else {
            counter = 0;
        }
        if (counter == 4) {
            return true;
        }
    }
    return false;
}