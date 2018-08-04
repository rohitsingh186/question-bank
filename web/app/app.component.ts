import {Component, OnInit} from '@angular/core';

import {RestService} from './rest.service';

@Component({
    moduleId: module.id,
    selector: 'my-app',
    templateUrl: 'app.component.html'
})

export class AppComponent implements OnInit {
    rows = ['5', '4', '3', '2', '1', '0'];
    cols = ['0', '1', '2', '3', '4', '5', '6'];
    currentPlayer: string;
    gameOver: boolean;
    lastPlayedColumn: number;
    waitingForLastPlayStatus = false;

    constructor(private restService: RestService) {}

    gridValues = {
        "0": {
            "0": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "1": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "2": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "3": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "4": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "5": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "6": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            }
        },
        "1": {
            "0": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "1": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "2": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "3": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "4": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "5": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "6": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            }
        },
        "2": {
            "0": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "1": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "2": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "3": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "4": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "5": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "6": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            }
        },
        "3": {
            "0": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "1": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "2": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "3": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "4": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "5": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "6": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            }
        },
        "4": {
            "0": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "1": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "2": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "3": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "4": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "5": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "6": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            }
        },
        "5": {
            "0": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "1": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "2": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "3": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "4": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "5": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            },
            "6": {
                "color": "BLANK",
                "friendlyNeighboursCounts": [0, 0, 0, 0, 0, 0, 0, 1]
            }
        }
    };

    updateBoard(): void {
        this.restService
            .getBoard()
            .then((data) => {
                this.gridValues = data;
            })
            .catch((error) => {
                console.log(error);
            });
    }

    play(event): void {
        if (!this.gameOver && !this.waitingForLastPlayStatus) {
            this.waitingForLastPlayStatus = true;
            let target = event.target || event.srcElement || event.currentTarget;
            let idAttr = target.attributes.id;
            let value = idAttr.nodeValue;
            this.lastPlayedColumn = Number(value.substring(9));

            this.restService.play(this.lastPlayedColumn - 1)
                .then((data) => {
                    this.gameOver = data.gameOver;
                    this.currentPlayer = data.nextPlayer;
                    this.updateBoard();
                    this.waitingForLastPlayStatus = false;
                })
                .catch((error) => {
                    console.log(error);
                });
        }
    }

    initializeGame(): void {
        this.waitingForLastPlayStatus = true;
        this.restService
            .initialize()
            .then((data) => {
                this.gameOver = data.gameOver;
                this.currentPlayer = data.nextPlayer;
                this.updateBoard();
                this.waitingForLastPlayStatus = false;
            })
            .catch((error) => {
                console.log(error);
            });
    }

    ngOnInit(): void {
        this.initializeGame();
    }
}