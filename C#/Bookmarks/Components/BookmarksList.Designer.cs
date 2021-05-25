
namespace Bookmarks.Components {
    partial class BookmarksList {
        /// <summary> 
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing) {
            if(disposing && (components != null)) {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent() {
            this.listBookmarks = new System.Windows.Forms.FlowLayoutPanel();
            this.SuspendLayout();
            // 
            // listBookmarks
            // 
            this.listBookmarks.AutoScroll = true;
            this.listBookmarks.AutoScrollMargin = new System.Drawing.Size(0, 20);
            this.listBookmarks.AutoScrollMinSize = new System.Drawing.Size(0, 10);
            this.listBookmarks.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.listBookmarks.Dock = System.Windows.Forms.DockStyle.Fill;
            this.listBookmarks.FlowDirection = System.Windows.Forms.FlowDirection.TopDown;
            this.listBookmarks.ForeColor = System.Drawing.Color.White;
            this.listBookmarks.Location = new System.Drawing.Point(0, 0);
            this.listBookmarks.MinimumSize = new System.Drawing.Size(500, 0);
            this.listBookmarks.Name = "listBookmarks";
            this.listBookmarks.Size = new System.Drawing.Size(917, 331);
            this.listBookmarks.TabIndex = 0;
            this.listBookmarks.WrapContents = false;
            this.listBookmarks.Resize += new System.EventHandler(this.OnResize);
            // 
            // BookmarksList
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(35)))), ((int)(((byte)(39)))), ((int)(((byte)(42)))));
            this.Controls.Add(this.listBookmarks);
            this.Margin = new System.Windows.Forms.Padding(5);
            this.MinimumSize = new System.Drawing.Size(500, 0);
            this.Name = "BookmarksList";
            this.Size = new System.Drawing.Size(917, 331);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.FlowLayoutPanel listBookmarks;
    }
}
