<?php
// Test de la classe Jeu
include(__DIR__."/../model/game.class.php");

// But : trouver la valeur 801
$game = new Game();

echo $game->guess()."\n";
$game->guessTooLow();
echo $game->guess()."\n";
$game->guessTooLow();
echo $game->guess()."\n";
$game->guessTooHigh();
echo $game->guess()."\n";
$game->guessTooHigh();
echo $game->guess()."\n";
$game->guessTooLow();
echo $game->guess()."\n";
$game->guessTooLow();
echo $game->guess()."\n";
$game->guessTooHigh();
echo $game->guess()."\n";
$game->guessTooLow();
echo $game->guess()."\n";
$game->guessTooHigh();
echo $game->guess()."\n";
?>
