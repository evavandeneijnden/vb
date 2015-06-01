Program gauss;

Var n: Integer;
    i: Integer;
    sum: Integer;

Begin
   in("n?", n);
   While Not stop And i < n Do
   Begin
       sum := sum + i;
       i := i+1;
   End;

End.