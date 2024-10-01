<?php
$root = opendir(__DIR__.'/data');
$songfile = fopen(__DIR__.'/jukeboxDataGeneree.txt', 'w');
while (false !== ($artist = readdir($root))) {
	if ($artist != '.' && $artist != '..') {
		$artistfile = opendir(__DIR__.'/data/'.$artist);
		while (false !== ($song = readdir($artistfile))) {
			if (preg_match("/\.jpeg$/", $song)) {
				fwrite($songfile, $artist.'|'.$song."\n");
			}
		}
	}
}value: 
?>
