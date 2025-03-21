// Generated from /Users/tianyipeng/IdeaProjects/mobius-inceptor/src/main/antlr4/com/haizhi/mobius/parser/SqlScript.g4 by ANTLR 4.5.3
package antlr.sql;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlScriptParser}.
 */
public interface SqlScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#sqlScript}.
	 * @param ctx the parse tree
	 */
	void enterSqlScript(SqlScriptParser.SqlScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#sqlScript}.
	 * @param ctx the parse tree
	 */
	void exitSqlScript(SqlScriptParser.SqlScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#mlStatement}.
	 * @param ctx the parse tree
	 */
	void enterMlStatement(SqlScriptParser.MlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#mlStatement}.
	 * @param ctx the parse tree
	 */
	void exitMlStatement(SqlScriptParser.MlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#trainStatement}.
	 * @param ctx the parse tree
	 */
	void enterTrainStatement(SqlScriptParser.TrainStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#trainStatement}.
	 * @param ctx the parse tree
	 */
	void exitTrainStatement(SqlScriptParser.TrainStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#predictStatement}.
	 * @param ctx the parse tree
	 */
	void enterPredictStatement(SqlScriptParser.PredictStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#predictStatement}.
	 * @param ctx the parse tree
	 */
	void exitPredictStatement(SqlScriptParser.PredictStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#variableDefined}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefined(SqlScriptParser.VariableDefinedContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#variableDefined}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefined(SqlScriptParser.VariableDefinedContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#tempTable}.
	 * @param ctx the parse tree
	 */
	void enterTempTable(SqlScriptParser.TempTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#tempTable}.
	 * @param ctx the parse tree
	 */
	void exitTempTable(SqlScriptParser.TempTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#udtStatement}.
	 * @param ctx the parse tree
	 */
	void enterUdtStatement(SqlScriptParser.UdtStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#udtStatement}.
	 * @param ctx the parse tree
	 */
	void exitUdtStatement(SqlScriptParser.UdtStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#udtChainExpression}.
	 * @param ctx the parse tree
	 */
	void enterUdtChainExpression(SqlScriptParser.UdtChainExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#udtChainExpression}.
	 * @param ctx the parse tree
	 */
	void exitUdtChainExpression(SqlScriptParser.UdtChainExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#udtExpression}.
	 * @param ctx the parse tree
	 */
	void enterUdtExpression(SqlScriptParser.UdtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#udtExpression}.
	 * @param ctx the parse tree
	 */
	void exitUdtExpression(SqlScriptParser.UdtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#udtTableList}.
	 * @param ctx the parse tree
	 */
	void enterUdtTableList(SqlScriptParser.UdtTableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#udtTableList}.
	 * @param ctx the parse tree
	 */
	void exitUdtTableList(SqlScriptParser.UdtTableListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#jsonValue}.
	 * @param ctx the parse tree
	 */
	void enterJsonValue(SqlScriptParser.JsonValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#jsonValue}.
	 * @param ctx the parse tree
	 */
	void exitJsonValue(SqlScriptParser.JsonValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(SqlScriptParser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(SqlScriptParser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(SqlScriptParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(SqlScriptParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#outputTable}.
	 * @param ctx the parse tree
	 */
	void enterOutputTable(SqlScriptParser.OutputTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#outputTable}.
	 * @param ctx the parse tree
	 */
	void exitOutputTable(SqlScriptParser.OutputTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSingleStatement(SqlScriptParser.SingleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSingleStatement(SqlScriptParser.SingleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSingleExpression(SqlScriptParser.SingleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSingleExpression(SqlScriptParser.SingleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#singleTableIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterSingleTableIdentifier(SqlScriptParser.SingleTableIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#singleTableIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitSingleTableIdentifier(SqlScriptParser.SingleTableIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#singleFunctionIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterSingleFunctionIdentifier(SqlScriptParser.SingleFunctionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#singleFunctionIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitSingleFunctionIdentifier(SqlScriptParser.SingleFunctionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#singleDataType}.
	 * @param ctx the parse tree
	 */
	void enterSingleDataType(SqlScriptParser.SingleDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#singleDataType}.
	 * @param ctx the parse tree
	 */
	void exitSingleDataType(SqlScriptParser.SingleDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statementDefault}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementDefault(SqlScriptParser.StatementDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementDefault}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementDefault(SqlScriptParser.StatementDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code use}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterUse(SqlScriptParser.UseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code use}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitUse(SqlScriptParser.UseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createDatabase}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCreateDatabase(SqlScriptParser.CreateDatabaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createDatabase}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCreateDatabase(SqlScriptParser.CreateDatabaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setDatabaseProperties}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSetDatabaseProperties(SqlScriptParser.SetDatabasePropertiesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setDatabaseProperties}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSetDatabaseProperties(SqlScriptParser.SetDatabasePropertiesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropDatabase}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDropDatabase(SqlScriptParser.DropDatabaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropDatabase}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDropDatabase(SqlScriptParser.DropDatabaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCreateTable(SqlScriptParser.CreateTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCreateTable(SqlScriptParser.CreateTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createHiveTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCreateHiveTable(SqlScriptParser.CreateHiveTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createHiveTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCreateHiveTable(SqlScriptParser.CreateHiveTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createTableLike}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCreateTableLike(SqlScriptParser.CreateTableLikeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createTableLike}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCreateTableLike(SqlScriptParser.CreateTableLikeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code analyze}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAnalyze(SqlScriptParser.AnalyzeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code analyze}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAnalyze(SqlScriptParser.AnalyzeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addTableColumns}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAddTableColumns(SqlScriptParser.AddTableColumnsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addTableColumns}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAddTableColumns(SqlScriptParser.AddTableColumnsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code renameTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRenameTable(SqlScriptParser.RenameTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code renameTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRenameTable(SqlScriptParser.RenameTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setTableProperties}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSetTableProperties(SqlScriptParser.SetTablePropertiesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setTableProperties}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSetTableProperties(SqlScriptParser.SetTablePropertiesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unsetTableProperties}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterUnsetTableProperties(SqlScriptParser.UnsetTablePropertiesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unsetTableProperties}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitUnsetTableProperties(SqlScriptParser.UnsetTablePropertiesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code changeColumn}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterChangeColumn(SqlScriptParser.ChangeColumnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code changeColumn}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitChangeColumn(SqlScriptParser.ChangeColumnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setTableSerDe}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSetTableSerDe(SqlScriptParser.SetTableSerDeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setTableSerDe}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSetTableSerDe(SqlScriptParser.SetTableSerDeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addTablePartition}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAddTablePartition(SqlScriptParser.AddTablePartitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addTablePartition}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAddTablePartition(SqlScriptParser.AddTablePartitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code renameTablePartition}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRenameTablePartition(SqlScriptParser.RenameTablePartitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code renameTablePartition}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRenameTablePartition(SqlScriptParser.RenameTablePartitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropTablePartitions}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDropTablePartitions(SqlScriptParser.DropTablePartitionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropTablePartitions}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDropTablePartitions(SqlScriptParser.DropTablePartitionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setTableLocation}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSetTableLocation(SqlScriptParser.SetTableLocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setTableLocation}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSetTableLocation(SqlScriptParser.SetTableLocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code recoverPartitions}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRecoverPartitions(SqlScriptParser.RecoverPartitionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code recoverPartitions}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRecoverPartitions(SqlScriptParser.RecoverPartitionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDropTable(SqlScriptParser.DropTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDropTable(SqlScriptParser.DropTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createView}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCreateView(SqlScriptParser.CreateViewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createView}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCreateView(SqlScriptParser.CreateViewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createTempViewUsing}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCreateTempViewUsing(SqlScriptParser.CreateTempViewUsingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createTempViewUsing}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCreateTempViewUsing(SqlScriptParser.CreateTempViewUsingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code alterViewQuery}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAlterViewQuery(SqlScriptParser.AlterViewQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code alterViewQuery}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAlterViewQuery(SqlScriptParser.AlterViewQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createFunction}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCreateFunction(SqlScriptParser.CreateFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createFunction}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCreateFunction(SqlScriptParser.CreateFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropFunction}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDropFunction(SqlScriptParser.DropFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropFunction}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDropFunction(SqlScriptParser.DropFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code explain}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExplain(SqlScriptParser.ExplainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code explain}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExplain(SqlScriptParser.ExplainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showTables}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterShowTables(SqlScriptParser.ShowTablesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showTables}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitShowTables(SqlScriptParser.ShowTablesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterShowTable(SqlScriptParser.ShowTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitShowTable(SqlScriptParser.ShowTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showDatabases}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterShowDatabases(SqlScriptParser.ShowDatabasesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showDatabases}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitShowDatabases(SqlScriptParser.ShowDatabasesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showTblProperties}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterShowTblProperties(SqlScriptParser.ShowTblPropertiesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showTblProperties}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitShowTblProperties(SqlScriptParser.ShowTblPropertiesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showColumns}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterShowColumns(SqlScriptParser.ShowColumnsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showColumns}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitShowColumns(SqlScriptParser.ShowColumnsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showPartitions}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterShowPartitions(SqlScriptParser.ShowPartitionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showPartitions}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitShowPartitions(SqlScriptParser.ShowPartitionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showFunctions}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterShowFunctions(SqlScriptParser.ShowFunctionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showFunctions}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitShowFunctions(SqlScriptParser.ShowFunctionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showCreateTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterShowCreateTable(SqlScriptParser.ShowCreateTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showCreateTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitShowCreateTable(SqlScriptParser.ShowCreateTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code describeFunction}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDescribeFunction(SqlScriptParser.DescribeFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code describeFunction}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDescribeFunction(SqlScriptParser.DescribeFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code describeDatabase}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDescribeDatabase(SqlScriptParser.DescribeDatabaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code describeDatabase}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDescribeDatabase(SqlScriptParser.DescribeDatabaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code describeTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDescribeTable(SqlScriptParser.DescribeTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code describeTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDescribeTable(SqlScriptParser.DescribeTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code refreshTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRefreshTable(SqlScriptParser.RefreshTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code refreshTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRefreshTable(SqlScriptParser.RefreshTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code refreshResource}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRefreshResource(SqlScriptParser.RefreshResourceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code refreshResource}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRefreshResource(SqlScriptParser.RefreshResourceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cacheTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCacheTable(SqlScriptParser.CacheTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cacheTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCacheTable(SqlScriptParser.CacheTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code uncacheTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterUncacheTable(SqlScriptParser.UncacheTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code uncacheTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitUncacheTable(SqlScriptParser.UncacheTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code clearCache}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterClearCache(SqlScriptParser.ClearCacheContext ctx);
	/**
	 * Exit a parse tree produced by the {@code clearCache}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitClearCache(SqlScriptParser.ClearCacheContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loadData}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLoadData(SqlScriptParser.LoadDataContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loadData}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLoadData(SqlScriptParser.LoadDataContext ctx);
	/**
	 * Enter a parse tree produced by the {@code truncateTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterTruncateTable(SqlScriptParser.TruncateTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code truncateTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitTruncateTable(SqlScriptParser.TruncateTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code repairTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRepairTable(SqlScriptParser.RepairTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code repairTable}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRepairTable(SqlScriptParser.RepairTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code manageResource}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterManageResource(SqlScriptParser.ManageResourceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code manageResource}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitManageResource(SqlScriptParser.ManageResourceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code failNativeCommand}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFailNativeCommand(SqlScriptParser.FailNativeCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code failNativeCommand}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFailNativeCommand(SqlScriptParser.FailNativeCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setConfiguration}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSetConfiguration(SqlScriptParser.SetConfigurationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setConfiguration}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSetConfiguration(SqlScriptParser.SetConfigurationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code resetConfiguration}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterResetConfiguration(SqlScriptParser.ResetConfigurationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code resetConfiguration}
	 * labeled alternative in {@link SqlScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitResetConfiguration(SqlScriptParser.ResetConfigurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#unsupportedHiveNativeCommands}.
	 * @param ctx the parse tree
	 */
	void enterUnsupportedHiveNativeCommands(SqlScriptParser.UnsupportedHiveNativeCommandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#unsupportedHiveNativeCommands}.
	 * @param ctx the parse tree
	 */
	void exitUnsupportedHiveNativeCommands(SqlScriptParser.UnsupportedHiveNativeCommandsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#createTableHeader}.
	 * @param ctx the parse tree
	 */
	void enterCreateTableHeader(SqlScriptParser.CreateTableHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#createTableHeader}.
	 * @param ctx the parse tree
	 */
	void exitCreateTableHeader(SqlScriptParser.CreateTableHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#bucketSpec}.
	 * @param ctx the parse tree
	 */
	void enterBucketSpec(SqlScriptParser.BucketSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#bucketSpec}.
	 * @param ctx the parse tree
	 */
	void exitBucketSpec(SqlScriptParser.BucketSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#skewSpec}.
	 * @param ctx the parse tree
	 */
	void enterSkewSpec(SqlScriptParser.SkewSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#skewSpec}.
	 * @param ctx the parse tree
	 */
	void exitSkewSpec(SqlScriptParser.SkewSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#locationSpec}.
	 * @param ctx the parse tree
	 */
	void enterLocationSpec(SqlScriptParser.LocationSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#locationSpec}.
	 * @param ctx the parse tree
	 */
	void exitLocationSpec(SqlScriptParser.LocationSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(SqlScriptParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(SqlScriptParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void enterInsertInto(SqlScriptParser.InsertIntoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void exitInsertInto(SqlScriptParser.InsertIntoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#partitionSpecLocation}.
	 * @param ctx the parse tree
	 */
	void enterPartitionSpecLocation(SqlScriptParser.PartitionSpecLocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#partitionSpecLocation}.
	 * @param ctx the parse tree
	 */
	void exitPartitionSpecLocation(SqlScriptParser.PartitionSpecLocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#partitionSpec}.
	 * @param ctx the parse tree
	 */
	void enterPartitionSpec(SqlScriptParser.PartitionSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#partitionSpec}.
	 * @param ctx the parse tree
	 */
	void exitPartitionSpec(SqlScriptParser.PartitionSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#partitionVal}.
	 * @param ctx the parse tree
	 */
	void enterPartitionVal(SqlScriptParser.PartitionValContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#partitionVal}.
	 * @param ctx the parse tree
	 */
	void exitPartitionVal(SqlScriptParser.PartitionValContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#describeFuncName}.
	 * @param ctx the parse tree
	 */
	void enterDescribeFuncName(SqlScriptParser.DescribeFuncNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#describeFuncName}.
	 * @param ctx the parse tree
	 */
	void exitDescribeFuncName(SqlScriptParser.DescribeFuncNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#describeColName}.
	 * @param ctx the parse tree
	 */
	void enterDescribeColName(SqlScriptParser.DescribeColNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#describeColName}.
	 * @param ctx the parse tree
	 */
	void exitDescribeColName(SqlScriptParser.DescribeColNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#ctes}.
	 * @param ctx the parse tree
	 */
	void enterCtes(SqlScriptParser.CtesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#ctes}.
	 * @param ctx the parse tree
	 */
	void exitCtes(SqlScriptParser.CtesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#namedQuery}.
	 * @param ctx the parse tree
	 */
	void enterNamedQuery(SqlScriptParser.NamedQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#namedQuery}.
	 * @param ctx the parse tree
	 */
	void exitNamedQuery(SqlScriptParser.NamedQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#tableProvider}.
	 * @param ctx the parse tree
	 */
	void enterTableProvider(SqlScriptParser.TableProviderContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#tableProvider}.
	 * @param ctx the parse tree
	 */
	void exitTableProvider(SqlScriptParser.TableProviderContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#tablePropertyList}.
	 * @param ctx the parse tree
	 */
	void enterTablePropertyList(SqlScriptParser.TablePropertyListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#tablePropertyList}.
	 * @param ctx the parse tree
	 */
	void exitTablePropertyList(SqlScriptParser.TablePropertyListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#tableProperty}.
	 * @param ctx the parse tree
	 */
	void enterTableProperty(SqlScriptParser.TablePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#tableProperty}.
	 * @param ctx the parse tree
	 */
	void exitTableProperty(SqlScriptParser.TablePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#tablePropertyKey}.
	 * @param ctx the parse tree
	 */
	void enterTablePropertyKey(SqlScriptParser.TablePropertyKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#tablePropertyKey}.
	 * @param ctx the parse tree
	 */
	void exitTablePropertyKey(SqlScriptParser.TablePropertyKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#tablePropertyValue}.
	 * @param ctx the parse tree
	 */
	void enterTablePropertyValue(SqlScriptParser.TablePropertyValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#tablePropertyValue}.
	 * @param ctx the parse tree
	 */
	void exitTablePropertyValue(SqlScriptParser.TablePropertyValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#constantList}.
	 * @param ctx the parse tree
	 */
	void enterConstantList(SqlScriptParser.ConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#constantList}.
	 * @param ctx the parse tree
	 */
	void exitConstantList(SqlScriptParser.ConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#nestedConstantList}.
	 * @param ctx the parse tree
	 */
	void enterNestedConstantList(SqlScriptParser.NestedConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#nestedConstantList}.
	 * @param ctx the parse tree
	 */
	void exitNestedConstantList(SqlScriptParser.NestedConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#createFileFormat}.
	 * @param ctx the parse tree
	 */
	void enterCreateFileFormat(SqlScriptParser.CreateFileFormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#createFileFormat}.
	 * @param ctx the parse tree
	 */
	void exitCreateFileFormat(SqlScriptParser.CreateFileFormatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableFileFormat}
	 * labeled alternative in {@link SqlScriptParser#fileFormat}.
	 * @param ctx the parse tree
	 */
	void enterTableFileFormat(SqlScriptParser.TableFileFormatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableFileFormat}
	 * labeled alternative in {@link SqlScriptParser#fileFormat}.
	 * @param ctx the parse tree
	 */
	void exitTableFileFormat(SqlScriptParser.TableFileFormatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code genericFileFormat}
	 * labeled alternative in {@link SqlScriptParser#fileFormat}.
	 * @param ctx the parse tree
	 */
	void enterGenericFileFormat(SqlScriptParser.GenericFileFormatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code genericFileFormat}
	 * labeled alternative in {@link SqlScriptParser#fileFormat}.
	 * @param ctx the parse tree
	 */
	void exitGenericFileFormat(SqlScriptParser.GenericFileFormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#storageHandler}.
	 * @param ctx the parse tree
	 */
	void enterStorageHandler(SqlScriptParser.StorageHandlerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#storageHandler}.
	 * @param ctx the parse tree
	 */
	void exitStorageHandler(SqlScriptParser.StorageHandlerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(SqlScriptParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(SqlScriptParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleInsertQuery}
	 * labeled alternative in {@link SqlScriptParser#queryNoWith}.
	 * @param ctx the parse tree
	 */
	void enterSingleInsertQuery(SqlScriptParser.SingleInsertQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleInsertQuery}
	 * labeled alternative in {@link SqlScriptParser#queryNoWith}.
	 * @param ctx the parse tree
	 */
	void exitSingleInsertQuery(SqlScriptParser.SingleInsertQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiInsertQuery}
	 * labeled alternative in {@link SqlScriptParser#queryNoWith}.
	 * @param ctx the parse tree
	 */
	void enterMultiInsertQuery(SqlScriptParser.MultiInsertQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiInsertQuery}
	 * labeled alternative in {@link SqlScriptParser#queryNoWith}.
	 * @param ctx the parse tree
	 */
	void exitMultiInsertQuery(SqlScriptParser.MultiInsertQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#queryOrganization}.
	 * @param ctx the parse tree
	 */
	void enterQueryOrganization(SqlScriptParser.QueryOrganizationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#queryOrganization}.
	 * @param ctx the parse tree
	 */
	void exitQueryOrganization(SqlScriptParser.QueryOrganizationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#multiInsertQueryBody}.
	 * @param ctx the parse tree
	 */
	void enterMultiInsertQueryBody(SqlScriptParser.MultiInsertQueryBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#multiInsertQueryBody}.
	 * @param ctx the parse tree
	 */
	void exitMultiInsertQueryBody(SqlScriptParser.MultiInsertQueryBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code queryTermDefault}
	 * labeled alternative in {@link SqlScriptParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void enterQueryTermDefault(SqlScriptParser.QueryTermDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code queryTermDefault}
	 * labeled alternative in {@link SqlScriptParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void exitQueryTermDefault(SqlScriptParser.QueryTermDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setOperation}
	 * labeled alternative in {@link SqlScriptParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void enterSetOperation(SqlScriptParser.SetOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setOperation}
	 * labeled alternative in {@link SqlScriptParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void exitSetOperation(SqlScriptParser.SetOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code queryPrimaryDefault}
	 * labeled alternative in {@link SqlScriptParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterQueryPrimaryDefault(SqlScriptParser.QueryPrimaryDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code queryPrimaryDefault}
	 * labeled alternative in {@link SqlScriptParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitQueryPrimaryDefault(SqlScriptParser.QueryPrimaryDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code table}
	 * labeled alternative in {@link SqlScriptParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterTable(SqlScriptParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code table}
	 * labeled alternative in {@link SqlScriptParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitTable(SqlScriptParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inlineTableDefault1}
	 * labeled alternative in {@link SqlScriptParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterInlineTableDefault1(SqlScriptParser.InlineTableDefault1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code inlineTableDefault1}
	 * labeled alternative in {@link SqlScriptParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitInlineTableDefault1(SqlScriptParser.InlineTableDefault1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code subquery}
	 * labeled alternative in {@link SqlScriptParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(SqlScriptParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subquery}
	 * labeled alternative in {@link SqlScriptParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(SqlScriptParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#sortItem}.
	 * @param ctx the parse tree
	 */
	void enterSortItem(SqlScriptParser.SortItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#sortItem}.
	 * @param ctx the parse tree
	 */
	void exitSortItem(SqlScriptParser.SortItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecification(SqlScriptParser.QuerySpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecification(SqlScriptParser.QuerySpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#hint}.
	 * @param ctx the parse tree
	 */
	void enterHint(SqlScriptParser.HintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#hint}.
	 * @param ctx the parse tree
	 */
	void exitHint(SqlScriptParser.HintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#hintStatement}.
	 * @param ctx the parse tree
	 */
	void enterHintStatement(SqlScriptParser.HintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#hintStatement}.
	 * @param ctx the parse tree
	 */
	void exitHintStatement(SqlScriptParser.HintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(SqlScriptParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(SqlScriptParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#aggregation}.
	 * @param ctx the parse tree
	 */
	void enterAggregation(SqlScriptParser.AggregationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#aggregation}.
	 * @param ctx the parse tree
	 */
	void exitAggregation(SqlScriptParser.AggregationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#groupingSet}.
	 * @param ctx the parse tree
	 */
	void enterGroupingSet(SqlScriptParser.GroupingSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#groupingSet}.
	 * @param ctx the parse tree
	 */
	void exitGroupingSet(SqlScriptParser.GroupingSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#lateralView}.
	 * @param ctx the parse tree
	 */
	void enterLateralView(SqlScriptParser.LateralViewContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#lateralView}.
	 * @param ctx the parse tree
	 */
	void exitLateralView(SqlScriptParser.LateralViewContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void enterSetQuantifier(SqlScriptParser.SetQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void exitSetQuantifier(SqlScriptParser.SetQuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(SqlScriptParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(SqlScriptParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#joinRelation}.
	 * @param ctx the parse tree
	 */
	void enterJoinRelation(SqlScriptParser.JoinRelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#joinRelation}.
	 * @param ctx the parse tree
	 */
	void exitJoinRelation(SqlScriptParser.JoinRelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#joinType}.
	 * @param ctx the parse tree
	 */
	void enterJoinType(SqlScriptParser.JoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#joinType}.
	 * @param ctx the parse tree
	 */
	void exitJoinType(SqlScriptParser.JoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#joinCriteria}.
	 * @param ctx the parse tree
	 */
	void enterJoinCriteria(SqlScriptParser.JoinCriteriaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#joinCriteria}.
	 * @param ctx the parse tree
	 */
	void exitJoinCriteria(SqlScriptParser.JoinCriteriaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#sample}.
	 * @param ctx the parse tree
	 */
	void enterSample(SqlScriptParser.SampleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#sample}.
	 * @param ctx the parse tree
	 */
	void exitSample(SqlScriptParser.SampleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(SqlScriptParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(SqlScriptParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#identifierSeq}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierSeq(SqlScriptParser.IdentifierSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#identifierSeq}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierSeq(SqlScriptParser.IdentifierSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#orderedIdentifierList}.
	 * @param ctx the parse tree
	 */
	void enterOrderedIdentifierList(SqlScriptParser.OrderedIdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#orderedIdentifierList}.
	 * @param ctx the parse tree
	 */
	void exitOrderedIdentifierList(SqlScriptParser.OrderedIdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#orderedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterOrderedIdentifier(SqlScriptParser.OrderedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#orderedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitOrderedIdentifier(SqlScriptParser.OrderedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#identifierCommentList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierCommentList(SqlScriptParser.IdentifierCommentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#identifierCommentList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierCommentList(SqlScriptParser.IdentifierCommentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#identifierComment}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierComment(SqlScriptParser.IdentifierCommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#identifierComment}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierComment(SqlScriptParser.IdentifierCommentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableName}
	 * labeled alternative in {@link SqlScriptParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterTableName(SqlScriptParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableName}
	 * labeled alternative in {@link SqlScriptParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitTableName(SqlScriptParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aliasedQuery}
	 * labeled alternative in {@link SqlScriptParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterAliasedQuery(SqlScriptParser.AliasedQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aliasedQuery}
	 * labeled alternative in {@link SqlScriptParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitAliasedQuery(SqlScriptParser.AliasedQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aliasedRelation}
	 * labeled alternative in {@link SqlScriptParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterAliasedRelation(SqlScriptParser.AliasedRelationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aliasedRelation}
	 * labeled alternative in {@link SqlScriptParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitAliasedRelation(SqlScriptParser.AliasedRelationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inlineTableDefault2}
	 * labeled alternative in {@link SqlScriptParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterInlineTableDefault2(SqlScriptParser.InlineTableDefault2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code inlineTableDefault2}
	 * labeled alternative in {@link SqlScriptParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitInlineTableDefault2(SqlScriptParser.InlineTableDefault2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code tableValuedFunction}
	 * labeled alternative in {@link SqlScriptParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterTableValuedFunction(SqlScriptParser.TableValuedFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableValuedFunction}
	 * labeled alternative in {@link SqlScriptParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitTableValuedFunction(SqlScriptParser.TableValuedFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#inlineTable}.
	 * @param ctx the parse tree
	 */
	void enterInlineTable(SqlScriptParser.InlineTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#inlineTable}.
	 * @param ctx the parse tree
	 */
	void exitInlineTable(SqlScriptParser.InlineTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rowFormatSerde}
	 * labeled alternative in {@link SqlScriptParser#rowFormat}.
	 * @param ctx the parse tree
	 */
	void enterRowFormatSerde(SqlScriptParser.RowFormatSerdeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rowFormatSerde}
	 * labeled alternative in {@link SqlScriptParser#rowFormat}.
	 * @param ctx the parse tree
	 */
	void exitRowFormatSerde(SqlScriptParser.RowFormatSerdeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rowFormatDelimited}
	 * labeled alternative in {@link SqlScriptParser#rowFormat}.
	 * @param ctx the parse tree
	 */
	void enterRowFormatDelimited(SqlScriptParser.RowFormatDelimitedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rowFormatDelimited}
	 * labeled alternative in {@link SqlScriptParser#rowFormat}.
	 * @param ctx the parse tree
	 */
	void exitRowFormatDelimited(SqlScriptParser.RowFormatDelimitedContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#tableIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTableIdentifier(SqlScriptParser.TableIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#tableIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTableIdentifier(SqlScriptParser.TableIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterFunctionIdentifier(SqlScriptParser.FunctionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitFunctionIdentifier(SqlScriptParser.FunctionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#namedExpression}.
	 * @param ctx the parse tree
	 */
	void enterNamedExpression(SqlScriptParser.NamedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#namedExpression}.
	 * @param ctx the parse tree
	 */
	void exitNamedExpression(SqlScriptParser.NamedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#namedExpressionSeq}.
	 * @param ctx the parse tree
	 */
	void enterNamedExpressionSeq(SqlScriptParser.NamedExpressionSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#namedExpressionSeq}.
	 * @param ctx the parse tree
	 */
	void exitNamedExpressionSeq(SqlScriptParser.NamedExpressionSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SqlScriptParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SqlScriptParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link SqlScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNot(SqlScriptParser.LogicalNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link SqlScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNot(SqlScriptParser.LogicalNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code optionalLogical}
	 * labeled alternative in {@link SqlScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterOptionalLogical(SqlScriptParser.OptionalLogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code optionalLogical}
	 * labeled alternative in {@link SqlScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitOptionalLogical(SqlScriptParser.OptionalLogicalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanDefault}
	 * labeled alternative in {@link SqlScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanDefault(SqlScriptParser.BooleanDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanDefault}
	 * labeled alternative in {@link SqlScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanDefault(SqlScriptParser.BooleanDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exists}
	 * labeled alternative in {@link SqlScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterExists(SqlScriptParser.ExistsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exists}
	 * labeled alternative in {@link SqlScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitExists(SqlScriptParser.ExistsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalBinary}
	 * labeled alternative in {@link SqlScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalBinary(SqlScriptParser.LogicalBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalBinary}
	 * labeled alternative in {@link SqlScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalBinary(SqlScriptParser.LogicalBinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#predicated}.
	 * @param ctx the parse tree
	 */
	void enterPredicated(SqlScriptParser.PredicatedContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#predicated}.
	 * @param ctx the parse tree
	 */
	void exitPredicated(SqlScriptParser.PredicatedContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(SqlScriptParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(SqlScriptParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExpressionDefault}
	 * labeled alternative in {@link SqlScriptParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpressionDefault(SqlScriptParser.ValueExpressionDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExpressionDefault}
	 * labeled alternative in {@link SqlScriptParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpressionDefault(SqlScriptParser.ValueExpressionDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link SqlScriptParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparison(SqlScriptParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link SqlScriptParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparison(SqlScriptParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmeticBinary}
	 * labeled alternative in {@link SqlScriptParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticBinary(SqlScriptParser.ArithmeticBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmeticBinary}
	 * labeled alternative in {@link SqlScriptParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticBinary(SqlScriptParser.ArithmeticBinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmeticUnary}
	 * labeled alternative in {@link SqlScriptParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticUnary(SqlScriptParser.ArithmeticUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmeticUnary}
	 * labeled alternative in {@link SqlScriptParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticUnary(SqlScriptParser.ArithmeticUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code struct}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterStruct(SqlScriptParser.StructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code struct}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitStruct(SqlScriptParser.StructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dereference}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterDereference(SqlScriptParser.DereferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dereference}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitDereference(SqlScriptParser.DereferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleCase}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCase(SqlScriptParser.SimpleCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleCase}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCase(SqlScriptParser.SimpleCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnReference}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnReference(SqlScriptParser.ColumnReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnReference}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnReference(SqlScriptParser.ColumnReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rowConstructor}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowConstructor(SqlScriptParser.RowConstructorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rowConstructor}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowConstructor(SqlScriptParser.RowConstructorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code last}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterLast(SqlScriptParser.LastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code last}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitLast(SqlScriptParser.LastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code star}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterStar(SqlScriptParser.StarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code star}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitStar(SqlScriptParser.StarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subscript}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSubscript(SqlScriptParser.SubscriptContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subscript}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSubscript(SqlScriptParser.SubscriptContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeFunctionCall}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterTimeFunctionCall(SqlScriptParser.TimeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeFunctionCall}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitTimeFunctionCall(SqlScriptParser.TimeFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subqueryExpression}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryExpression(SqlScriptParser.SubqueryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subqueryExpression}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryExpression(SqlScriptParser.SubqueryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cast}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterCast(SqlScriptParser.CastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cast}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitCast(SqlScriptParser.CastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantDefault}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantDefault(SqlScriptParser.ConstantDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantDefault}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantDefault(SqlScriptParser.ConstantDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesizedExpression}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(SqlScriptParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesizedExpression}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(SqlScriptParser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SqlScriptParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SqlScriptParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code searchedCase}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSearchedCase(SqlScriptParser.SearchedCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code searchedCase}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSearchedCase(SqlScriptParser.SearchedCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code first}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterFirst(SqlScriptParser.FirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code first}
	 * labeled alternative in {@link SqlScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitFirst(SqlScriptParser.FirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link SqlScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(SqlScriptParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link SqlScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(SqlScriptParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link SqlScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterIntervalLiteral(SqlScriptParser.IntervalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link SqlScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitIntervalLiteral(SqlScriptParser.IntervalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeConstructor}
	 * labeled alternative in {@link SqlScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterTypeConstructor(SqlScriptParser.TypeConstructorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeConstructor}
	 * labeled alternative in {@link SqlScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitTypeConstructor(SqlScriptParser.TypeConstructorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericLiteral}
	 * labeled alternative in {@link SqlScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteral(SqlScriptParser.NumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericLiteral}
	 * labeled alternative in {@link SqlScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteral(SqlScriptParser.NumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link SqlScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(SqlScriptParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link SqlScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(SqlScriptParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link SqlScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(SqlScriptParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link SqlScriptParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(SqlScriptParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(SqlScriptParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(SqlScriptParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOperator(SqlScriptParser.ArithmeticOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOperator(SqlScriptParser.ArithmeticOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#predicateOperator}.
	 * @param ctx the parse tree
	 */
	void enterPredicateOperator(SqlScriptParser.PredicateOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#predicateOperator}.
	 * @param ctx the parse tree
	 */
	void exitPredicateOperator(SqlScriptParser.PredicateOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(SqlScriptParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(SqlScriptParser.BooleanValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#interval}.
	 * @param ctx the parse tree
	 */
	void enterInterval(SqlScriptParser.IntervalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#interval}.
	 * @param ctx the parse tree
	 */
	void exitInterval(SqlScriptParser.IntervalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#intervalField}.
	 * @param ctx the parse tree
	 */
	void enterIntervalField(SqlScriptParser.IntervalFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#intervalField}.
	 * @param ctx the parse tree
	 */
	void exitIntervalField(SqlScriptParser.IntervalFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#intervalValue}.
	 * @param ctx the parse tree
	 */
	void enterIntervalValue(SqlScriptParser.IntervalValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#intervalValue}.
	 * @param ctx the parse tree
	 */
	void exitIntervalValue(SqlScriptParser.IntervalValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#colPosition}.
	 * @param ctx the parse tree
	 */
	void enterColPosition(SqlScriptParser.ColPositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#colPosition}.
	 * @param ctx the parse tree
	 */
	void exitColPosition(SqlScriptParser.ColPositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code complexDataType}
	 * labeled alternative in {@link SqlScriptParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterComplexDataType(SqlScriptParser.ComplexDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code complexDataType}
	 * labeled alternative in {@link SqlScriptParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitComplexDataType(SqlScriptParser.ComplexDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primitiveDataType}
	 * labeled alternative in {@link SqlScriptParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveDataType(SqlScriptParser.PrimitiveDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primitiveDataType}
	 * labeled alternative in {@link SqlScriptParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveDataType(SqlScriptParser.PrimitiveDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#colTypeList}.
	 * @param ctx the parse tree
	 */
	void enterColTypeList(SqlScriptParser.ColTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#colTypeList}.
	 * @param ctx the parse tree
	 */
	void exitColTypeList(SqlScriptParser.ColTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#colType}.
	 * @param ctx the parse tree
	 */
	void enterColType(SqlScriptParser.ColTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#colType}.
	 * @param ctx the parse tree
	 */
	void exitColType(SqlScriptParser.ColTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#complexColTypeList}.
	 * @param ctx the parse tree
	 */
	void enterComplexColTypeList(SqlScriptParser.ComplexColTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#complexColTypeList}.
	 * @param ctx the parse tree
	 */
	void exitComplexColTypeList(SqlScriptParser.ComplexColTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#complexColType}.
	 * @param ctx the parse tree
	 */
	void enterComplexColType(SqlScriptParser.ComplexColTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#complexColType}.
	 * @param ctx the parse tree
	 */
	void exitComplexColType(SqlScriptParser.ComplexColTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#whenClause}.
	 * @param ctx the parse tree
	 */
	void enterWhenClause(SqlScriptParser.WhenClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#whenClause}.
	 * @param ctx the parse tree
	 */
	void exitWhenClause(SqlScriptParser.WhenClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#windows}.
	 * @param ctx the parse tree
	 */
	void enterWindows(SqlScriptParser.WindowsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#windows}.
	 * @param ctx the parse tree
	 */
	void exitWindows(SqlScriptParser.WindowsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#namedWindow}.
	 * @param ctx the parse tree
	 */
	void enterNamedWindow(SqlScriptParser.NamedWindowContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#namedWindow}.
	 * @param ctx the parse tree
	 */
	void exitNamedWindow(SqlScriptParser.NamedWindowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code windowRef}
	 * labeled alternative in {@link SqlScriptParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void enterWindowRef(SqlScriptParser.WindowRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code windowRef}
	 * labeled alternative in {@link SqlScriptParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void exitWindowRef(SqlScriptParser.WindowRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code windowDef}
	 * labeled alternative in {@link SqlScriptParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void enterWindowDef(SqlScriptParser.WindowDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code windowDef}
	 * labeled alternative in {@link SqlScriptParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void exitWindowDef(SqlScriptParser.WindowDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#windowFrame}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrame(SqlScriptParser.WindowFrameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#windowFrame}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrame(SqlScriptParser.WindowFrameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#frameBound}.
	 * @param ctx the parse tree
	 */
	void enterFrameBound(SqlScriptParser.FrameBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#frameBound}.
	 * @param ctx the parse tree
	 */
	void exitFrameBound(SqlScriptParser.FrameBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(SqlScriptParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(SqlScriptParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(SqlScriptParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(SqlScriptParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unquotedIdentifier}
	 * labeled alternative in {@link SqlScriptParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterUnquotedIdentifier(SqlScriptParser.UnquotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unquotedIdentifier}
	 * labeled alternative in {@link SqlScriptParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitUnquotedIdentifier(SqlScriptParser.UnquotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code squareBracketIdentifier}
	 * labeled alternative in {@link SqlScriptParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterSquareBracketIdentifier(SqlScriptParser.SquareBracketIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code squareBracketIdentifier}
	 * labeled alternative in {@link SqlScriptParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitSquareBracketIdentifier(SqlScriptParser.SquareBracketIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quotedIdentifierAlternative}
	 * labeled alternative in {@link SqlScriptParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifierAlternative(SqlScriptParser.QuotedIdentifierAlternativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quotedIdentifierAlternative}
	 * labeled alternative in {@link SqlScriptParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifierAlternative(SqlScriptParser.QuotedIdentifierAlternativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifier(SqlScriptParser.QuotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifier(SqlScriptParser.QuotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void enterDecimalLiteral(SqlScriptParser.DecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void exitDecimalLiteral(SqlScriptParser.DecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(SqlScriptParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(SqlScriptParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bigIntLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void enterBigIntLiteral(SqlScriptParser.BigIntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bigIntLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void exitBigIntLiteral(SqlScriptParser.BigIntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code smallIntLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void enterSmallIntLiteral(SqlScriptParser.SmallIntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code smallIntLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void exitSmallIntLiteral(SqlScriptParser.SmallIntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tinyIntLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void enterTinyIntLiteral(SqlScriptParser.TinyIntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tinyIntLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void exitTinyIntLiteral(SqlScriptParser.TinyIntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void enterDoubleLiteral(SqlScriptParser.DoubleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void exitDoubleLiteral(SqlScriptParser.DoubleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bigDecimalLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void enterBigDecimalLiteral(SqlScriptParser.BigDecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bigDecimalLiteral}
	 * labeled alternative in {@link SqlScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void exitBigDecimalLiteral(SqlScriptParser.BigDecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlScriptParser#nonReserved}.
	 * @param ctx the parse tree
	 */
	void enterNonReserved(SqlScriptParser.NonReservedContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlScriptParser#nonReserved}.
	 * @param ctx the parse tree
	 */
	void exitNonReserved(SqlScriptParser.NonReservedContext ctx);
}