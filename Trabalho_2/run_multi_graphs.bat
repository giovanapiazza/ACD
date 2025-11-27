@echo off
cls

REM ==============================================
REM  TP2 - Execução automática N vezes (CSV)
REM ==============================================

set GRAPHS_DIR=graphs
set OUTPUT_CSV=resultados.csv

echo Arquivos disponíveis em %GRAPHS_DIR%:
echo ------------------------------------------------
for %%A in (%GRAPHS_DIR%\*.gr) do (
    echo   %%~nxA
)
echo ------------------------------------------------

echo.
set /p SELECTED="Digite os grafos desejados (separados por espaço): "

echo.
set /p TIMES="Executar quantas vezes cada grafo? "

echo.
echo Compilando Java...
javac graph\*.java
if %errorlevel% neq 0 (
    echo ERRO ao compilar código Java.
    pause
    exit /b
)

echo Limpando resultados anteriores...
del %OUTPUT_CSV% >nul 2>&1
echo arquivo,execucao,tempo_ms > %OUTPUT_CSV%

echo.
echo ==============================================
echo Iniciando execuções...
echo ==============================================
echo.

for %%G in (%SELECTED%) do (
    echo Rodando %%G...

    for /l %%i in (1,1,%TIMES%) do (

        REM -----------------------------
        REM Cria entrada simulada
        REM -----------------------------
        echo 1> temp_input.txt
        echo %GRAPHS_DIR%\%%G>> temp_input.txt
        echo true>> temp_input.txt
        echo true>> temp_input.txt
        echo 0>> temp_input.txt

        REM -----------------------------
        REM Cria script temporário run_once.bat
        REM -----------------------------
        echo @echo off > run_once.bat
        echo java graph.Main ^< temp_input.txt >> run_once.bat

        REM -----------------------------
        REM Mede tempo via CMD dentro do Measure-Command
        REM -----------------------------
        for /f "tokens=*" %%T in ('powershell -command "(Measure-Command { cmd /c run_once.bat }).TotalMilliseconds"') do (
            echo %%G,%%i,%%T >> %OUTPUT_CSV%
        )

        del temp_input.txt
        del run_once.bat
    )

    echo.
)

echo ==============================================
echo Finalizado.
echo Resultados salvos em: %OUTPUT_CSV%
echo ==============================================
pause
