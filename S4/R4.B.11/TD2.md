2.3

| No  | @IP source | Port source | @IP destination | Port destination | Protocole de transport | Etat de connexion | SYN seul |  Action  |
| --- | :--------: | :---------: | :-------------: | :--------------: | :--------------------: | :---------------: | :------: | :------: |
| 1   |     *      |      *      |   100.0.0.99    |        22        |          TCP           |         *         |    *     | Accepter |
| 2   | 100.0.0.99 |     22      |        *        |        *         |          TCP           |     Existante     |   Non    | Accepter |
| 3   | 100.0.0.99 |     53      |   200.0.0.53    |        53        |          UDP           |         *         |    X     | Accepter |
| 4   | 200.0.0.53 |     53      |   100.0.0.99    |        53        |          UDP           |     Existante     |    X     | Accepter |
| 5   | 100.0.0.99 |     53      |   200.0.0.53    |       587        |          TCP           |         *         |    *     | Accepter |
| 6   | 200.0.0.53 |     53      |   100.0.0.99    |       587        |          TCP           |     Existante     |   Non    | Accepter |
| 7   |     *      |      *      |        *        |        *         |           *            |         *         |    *     |  Lâcher  |
2.4

| No  | Interface source | @IP source | Port source | Interface destination | @IP destination | Port destination | Protocole de transport | Etat de connexion | SYN seul |  Action  |     |
| --- | :--------------: | :--------: | :---------: | :-------------------: | :-------------: | :--------------: | :--------------------: | :---------------: | :------: | :------: | --- |
| 1   |       eth0       |     *      |      *      |         eth2          |   100.0.0.99    |        22        |          TCP           |         *         |    *     | Accepter |     |
| 2   |       eth2       | 100.0.0.99 |     22      |         eth0          |        *        |        *         |          TCP           |     Existante     |   Non    | Accepter |     |
| 3   |       eth2       | 100.0.0.99 |     53      |         eth1          |   200.0.0.53    |        53        |          UDP           |         *         |    X     | Accepter |     |
| 4   |       eth1       | 200.0.0.53 |     53      |         eth2          |   100.0.0.99    |        53        |          UDP           |     Existante     |    X     | Accepter |     |
| 5   |       eth2       | 100.0.0.99 |     53      |         eth1          |   200.0.0.53    |       587        |          TCP           |         *         |    *     | Accepter |     |
| 6   |       eth1       | 200.0.0.53 |     53      |         eth2          |   100.0.0.99    |       587        |          TCP           |     Existante     |   Non    | Accepter |     |
| 7   |        *         |     *      |      *      |           *           |        *        |        *         |           *            |         *         |    *     |  Lâcher  |     |
