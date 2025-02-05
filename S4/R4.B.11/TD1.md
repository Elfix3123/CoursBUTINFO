1.1.

| No  | @IP source | Port source | @IP destination | Port destination | Protocole de transport | SYN seul |  Action   |
| --- | :--------: | :---------: | :-------------: | :--------------: | :--------------------: | :------: | :-------: |
| 1   |     *      |      *      |   100.0.0.99    |        80        |          TCP           |    *     | Autoriser |
| 2   | 100.0.0.99 |     80      |        *        |        *         |          TCP           |    *     | Autoriser |
| 3   |     *      |      *      |   100.0.0.99    |       443        |          TCP           |    *     | Autoriser |
| 4   | 100.0.0.99 |     443     |        *        |        *         |          TCP           |    *     | Autoriser |
| 5   |     *      |      *      |        *        |        *         |           *            |    *     |  Refuser  |
1.2.

| @IP source  | @IP destination |   Action    | No de Règle utilisée |
| :---------: | :-------------: | :---------: | :------------------: |
| 100.0.0.12  |   200.0.0.55    |    Refus    |          2           |
| 100.0.0.12  |   200.0.0.143   | Acceptation |          1           |
| 100.0.0.130 |   200.0.0.55    |    Refus    |          2           |
| 100.0.0.130 |   200.0.0.143   | Acceptation |          1           |
|   9.9.9.9   |   200.0.0.55    |    Refus    |          2           |
|   9.9.9.9   |   200.0.0.143   |    Refus    |          2           |
1.2.2.

| No  |   @IP source   | Port source | @IP destination | Port destination | Protocole de transport | SYN seul |  Action   |
| --- | :------------: | :---------: | :-------------: | :--------------: | :--------------------: | :------: | :-------: |
| 1   | 100.0.0.128/25 |      *      | 200.0.0.128/25  |        *         |           *            |    *     | Autoriser |
| 2   |       *        |      *      |        *        |        *         |           *            |    *     |  Refuser  |
