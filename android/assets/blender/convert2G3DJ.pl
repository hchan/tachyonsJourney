for $i (<*.fbx>) {
    $fbx = $i;
    $g3dj = $i;
    $g3dj =~ s#.fbx#.g3dj#;

    if ($ENV{'LOGNAME'}) {
    	`~/fbx-conv/fbx-conv-lin64 -f -o G3DJ $fbx $g3dj`;
    } else {
    	system("c:/fbx-conv/fbx-conv-win32.exe -f -o G3DJ $fbx $g3dj");
    }
}
