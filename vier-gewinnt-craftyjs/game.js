Crafty.init(500, 350, document.getElementById('game'));
Crafty.e('Floor, 2D, Canvas, Color').attr({x: 0, y: 350, w: 350, h: 1}).color('#F00');

var player = "Schwarz";
var matrix = [[]];

for (var column = 0; column < 7; column++) {
    matrix[column] = [];
    for (var line = 0; line < 6; line++) {
        matrix[column][line] = "Empty";
    }
}

Crafty.bind("KeyDown", function (e) {
    var column = e.key - 49;
    if (column < 0 || column > 6) {
        return;
    }
    var line = nextLineIndex(matrix[column]);
    if (line > 5) {
        return;
    }

    var squareColor = player == "Schwarz" ? '#F00' : 'green';
    var gravityTo = line == 0 ? 'Floor' : "x" + column + "" + (line - 1);

    Crafty.e("x" + column + "" + line + ', 2D, Canvas, Color, Gravity').attr({
        x: column * 50,
        y: 0,
        w: 50,
        h: 50
    }).color(squareColor).gravity(gravityTo);

    matrix[column][line] = player;

    if (checkWinner(column, line)) {
        alert(player + " gewinnt!")
    }

    player = (player == "Schwarz" ? "Gruen" : "Schwarz");
});

function nextLineIndex(columnArray) {
    for (var index = 0; index < 6; index++) {
        if (columnArray[index] == "Empty") {
            return index;
        }
    }
    return 6;
}

function checkWinner(column, line) {
    return checkVertical(column, line) || checkHorizontal(line) || checkAscendingDiagonal(column, line) || checkDescendingDiagonal(column, line);
}

function checkVertical(column, line) {
    if (line < 3) {
        return false
    }
    for (var index = line; index >= line - 3; index--) {
        if (matrix[column][index] != player) {
            return false;
        }
    }
    return true;
}

function checkHorizontal(line) {
    var counter = 0;
    for (var index = 0; index < 6; index++) {
        if (matrix[index][line] == player) {
            counter++;
            if (counter == 4) {
                return true;
            }
        } else {
            counter = 0;
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
    for (; startColumn < 7 && startLine < 6; startColumn++, startLine++) {
        if (matrix[startColumn][startLine] == player) {
            counter++;
            if (counter == 4) {
                return true;
            }
        } else {
            counter = 0;
        }
    }
    return false;
}

function checkDescendingDiagonal(column, line) {
    var startColumn = column;
    var startLine = line;
    while (startColumn < 6 && startLine > 0) {
        startColumn = startColumn + 1;
        startLine = startLine - 1;
    }
    var counter = 0;
    for (; startColumn >= 0 && startLine < 6; startColumn--, startLine++) {
        if (matrix[startColumn][startLine] == player) {
            counter++;
            if (counter == 4) {
                return true;
            }
        } else {
            counter = 0;
        }
    }
    return false;
}