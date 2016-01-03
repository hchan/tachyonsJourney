for $i (<*.fbx>) {
    $fbx = $i;
    $g3dj = $i;
    $g3dj =~ s#.fbx#.g3dj#;

    system("c:/fbx-conv/fbx-conv-win32.exe -f -o G3DJ $fbx $g3dj");
}
